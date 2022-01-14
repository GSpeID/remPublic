package ru.x3m.rem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.x3m.rem.controller.exeption.ResourceNotFoundException;
import ru.x3m.rem.dto.RepairDTO;
import ru.x3m.rem.entity.Repair;
import ru.x3m.rem.service.ManagementService;
import ru.x3m.rem.service.RepairService;

import javax.validation.Valid;
import java.util.List;


@Controller
public class RepairController {

    private RepairService repairService;
    private ManagementService managementService;

    @Autowired
    public RepairController(RepairService repairService) {
        this.repairService = repairService;
    }

    @GetMapping("/repair-service")
    public String repairPage(){
        return "redirect:/repair-service/all";
    }

    @GetMapping("/repair-service/all")
    public String allRepairsPage(Model model){
        List<Repair> repairs = repairService.findAllRepairs();
        model.addAttribute("repairs", repairs);
        return "repair-list";
    }

    @GetMapping("/repair/create")
    public String createService(Model model){
        model.addAttribute("repair", new RepairDTO());
        return "repair";
    }

    @PostMapping("/repair/create")
    public String createRepairPost(@ModelAttribute("repair")@Valid RepairDTO repairDTO,
                                   BindingResult result){
        if (result.hasErrors()){
            return "repair";
        }

        repairService.saveRepair(repairDTO);
        return "redirect:/";
    }


    @GetMapping("/repair-service/{repair_id}")
    public String repairPage(@PathVariable("repair_id") Long repair_service_id, Model model){
        RepairDTO repairDTO = repairService.findRepairById(repair_service_id)
                .orElseThrow(ResourceNotFoundException::new);
        model.addAttribute("repair", repairDTO);
        return "repair";
    }


    @GetMapping("/repair-service/delete/{repair_id}")
    public String deleteRepair(@PathVariable Long repair_id){
        repairService.deleteRepair(repair_id);
        return "redirect:/";
    }






}
