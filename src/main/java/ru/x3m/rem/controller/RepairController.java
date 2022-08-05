package ru.x3m.rem.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.x3m.rem.dto.RepairDTO;
import ru.x3m.rem.entity.Repair;
import ru.x3m.rem.service.ManagementService;
import ru.x3m.rem.service.RepairService;

import javax.validation.Valid;
import java.util.List;


@Controller
public class RepairController {

    private final RepairService repairService;
    private final ManagementService managementService;
    private final ModelMapper modelMapper;

    @Autowired
    public RepairController(RepairService repairService,
                            ManagementService managementService,
                            ModelMapper modelMapper) {
        this.repairService = repairService;
        this.managementService = managementService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/repair-service")
    public String allRepairsPage(Model model) {
        model.addAttribute("repairDTO", new RepairDTO());
        List<Repair> repairs = repairService.findAllRepairs();
        model.addAttribute("repairs", repairs);
        ManagementController.globalModelsList(model, managementService);
        return "repair-service";
    }

    @PostMapping("/repair-service/create")
    public String createRepairPost(@ModelAttribute("repairDTO") @Valid RepairDTO repairDTO,
                                   BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<Repair> repairs = repairService.findAllRepairs();
            model.addAttribute("repairs", repairs);
            ManagementController.globalModelsList(model, managementService);
            return "/repair-service";
        }
        repairService.saveRepair(repairDTO);
        return "redirect:/repair-service";
    }

    @GetMapping("/repair-service/delete/{repairId}")
    public String deleteRepair(@PathVariable Long repairId) {
        repairService.deleteRepair(repairId);
        return "redirect:/repair-service";
    }


}
