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
public class ManagementController {

    private ManagementService managementService;

    @Autowired
    public ManagementController(ManagementService managementService) {
        this.managementService = managementService;
    }

    @GetMapping("/repair-service/management")
    public String allManagementPage(Model model) {
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
        return "/management";
    }

    //----- Save\Delete Client

    @PostMapping("/repair-service/management/create-client")
    public String createClientPost(@ModelAttribute("client") @Valid ClientDTO clientDTO,
                                   Model model, BindingResult result) {
        if (result.hasErrors()) {
            return "/management";
        }
        managementService.saveClient(clientDTO);
        return "redirect:/repair-service/management";
    }

    @GetMapping("/repair-service/management/delete-client/{client_id}")
    public String deleteClient(@PathVariable Long client_id) {
        managementService.deleteClient(client_id);
        return "redirect:/repair-service/management";
    }

    //----- Save\Delete Client Type


    @PostMapping("/repair-service/management/create-client-type")
    public String createClientTypePost(@ModelAttribute("clientType")
                                       @Valid ClientTypeDTO clientTypeDTO,
                                       BindingResult result) {
        if (result.hasErrors()) {
            return "/management";
        }
        managementService.saveClientType(clientTypeDTO);
        return "redirect:/repair-service/management";
    }

    @GetMapping("/repair-service/management/delete-client-type/{client_type_id}")
    public String deleteClientType(@PathVariable Long client_type_id) {
        managementService.deleteClientType(client_type_id);
        return "redirect:/repair-service/management";
    }

    //----- Save\Delete Device

    @PostMapping("/repair-service/management/create-device")
    public String createDevicePost(@ModelAttribute("device")
                                   @Valid DeviceDTO deviceDTO,
                                   BindingResult result) {
        if (result.hasErrors()) {
            return "/management";
        }
        managementService.saveDevice(deviceDTO);
        return "redirect:/repair-service/management";
    }

    @GetMapping("/repair-service/management/delete-device/{device_id}")
    public String deleteDevice(@PathVariable Long device_id) {
        managementService.deleteDevice(device_id);
        return "redirect:/repair-service/management";
    }

    //----- Save\Delete Repair Type

    @PostMapping("/repair-service/management/create-repair-type")
    public String createRepairTypePost(@ModelAttribute("repairType")
                                       @Valid RepairTypeDTO repairTypeDTO,
                                       BindingResult result) {
        if (result.hasErrors()) {
            return "/management";
        }
        managementService.saveRepairType(repairTypeDTO);
        return "redirect:/repair-service/management";
    }

    @GetMapping("/repair-service/management/delete-repair-type/{repair_type_id}")
    public String deleteRepairType(@PathVariable Long repair_type_id) {
        managementService.deleteRepairType(repair_type_id);
        return "redirect:/repair-service/management";
    }

    //----- Save\Delete Statuses

    @PostMapping("/repair-service/management/create-status")
    public String createStatus(@ModelAttribute("status")
                               @Valid RepairStatusDTO repairStatusDTO,
                               BindingResult result) {
        if (result.hasErrors()) {
            return "/management";
        }
        managementService.saveStatus(repairStatusDTO);
        return "redirect:/repair-service/management";
    }

    @GetMapping("/repair-service/management/delete-status/{status_id}")
    public String deleteStatus(@PathVariable Long status_id){
        managementService.deleteStatus(status_id);
        return "redirect:/repair-service/management";
    }

}
