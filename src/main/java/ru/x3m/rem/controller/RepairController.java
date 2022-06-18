package ru.x3m.rem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.x3m.rem.dto.*;
import ru.x3m.rem.entity.*;
import ru.x3m.rem.service.*;

import javax.validation.Valid;
import java.util.List;


@Controller
public class RepairController {

    private RepairService repairService;
    private ManagementService managementService;

    @Autowired
    public RepairController(RepairService repairService, ManagementService managementService) {
        this.repairService = repairService;
        this.managementService = managementService;
    }

    @GetMapping("/repair-service")
    public String allRepairsPage(Model model) {
        List<Repair> repairs = repairService.findAllRepairs();
        model.addAttribute("repairs", repairs);
        List<Client> clients = managementService.findAllClients();
        model.addAttribute("clients", clients);
        List<Device> devices = managementService.findAllDevices();
        model.addAttribute("devices", devices);
        List<ClientType> clientTypes = managementService.findAllClientTypes();
        model.addAttribute("clientTypes", clientTypes);
        List<RepairType> repairTypes = managementService.findAllRepairTypes();
        model.addAttribute("repairTypes", repairTypes);
        List<RepairStatuses> repairStatuses = managementService.findAllRepairStatuses();
        model.addAttribute("repairStatuses", repairStatuses);
        return "repair-service";
    }

    @PostMapping("/repair-service/create")
    public String createRepairPost(@ModelAttribute("repair") @Valid RepairDTO repairDTO,
                                   BindingResult result) {
        if (result.hasErrors()) {
            return "repair-service";
        }

        repairService.saveRepair(repairDTO);
        return "redirect:/repair-service";
    }

    @GetMapping("/repair-service/delete/{repair_id}")
    public String deleteRepair(@PathVariable Long repair_id) {
        repairService.deleteRepair(repair_id);
        return "redirect:/repair-service";
    }

}
