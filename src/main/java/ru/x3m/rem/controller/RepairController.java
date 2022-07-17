package ru.x3m.rem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.x3m.rem.dto.*;
import ru.x3m.rem.entity.*;
import ru.x3m.rem.service.*;

import java.util.List;


@Controller
public class RepairController {

    private final RepairService repairService;
    private final ManagementService managementService;

    @Autowired
    public RepairController(RepairService repairService, ManagementService managementService) {
        this.repairService = repairService;
        this.managementService = managementService;
    }

    @GetMapping("/repair-service")
    public String allRepairsPage(Model model) {
        List<Repair> repairs = repairService.findAllRepairs();
        model.addAttribute("repairs", repairs);
        ManagementController.globalModelsList(model, managementService);
        return "repair-service";
    }

    @PostMapping("/repair-service/create")
    public String createRepairPost(@ModelAttribute("repair")  RepairDTO repairDTO,
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
