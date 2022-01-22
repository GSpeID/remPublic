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

    @Autowired
    public RepairController(RepairService repairService) {
        this.repairService = repairService;
    }


    @GetMapping("/repair-service")
    public String allRepairsPage(Model model){
        List<Repair> repairs = repairService.findAllRepairs();
        model.addAttribute("repairs", repairs);
        return "repair-service";
    }

    @PostMapping("/repair-service/create")
    public String createRepairPost(@ModelAttribute("repair")@Valid RepairDTO repairDTO,
                                   BindingResult result){
        if (result.hasErrors()){
            return "repair-service";
        }

        repairService.saveRepair(repairDTO);
        return "redirect:/repair-service";
    }

    @GetMapping("/repair-service/delete/{repair_id}")
    public String deleteRepair(@PathVariable Long repair_id){
        repairService.deleteRepair(repair_id);
        return "redirect:/repair-service";
    }


    //----- Management Page

    //----- For displaying all needed elements

    @GetMapping("/repair-service/management")
    public String allManagementPage(Model model){
        List<Client> clients = repairService.findAllClients();
        model.addAttribute("clients", clients);
        List<Device> devices = repairService.findAllDevices();
        model.addAttribute("devices", devices);
        List<ClientType> clientTypes = repairService.findAllClientTypes();
        model.addAttribute("clientTypes", clientTypes);
        List<RepairType> repairTypes = repairService.findAllRepairTypes();
        model.addAttribute("repairTypes", repairTypes);
        return "/management";
    }

    //----- Save\Delete Client

    @PostMapping("/repair-service/management/create-client")
    public String createClientPost(@ModelAttribute("client") @Valid ClientDTO clientDTO,
                                   BindingResult result){
        if (result.hasErrors()){
            return "/management";
        }
        repairService.saveClient(clientDTO);
        return "redirect:/repair-service/management";
    }

    @GetMapping("/repair-service/management/delete-client/{client_id}")
    public String deleteClient(@PathVariable Long client_id){
        repairService.deleteClient(client_id);
        return "redirect:/repair-service/management";
    }

    //----- Save\Delete Client Type


    @PostMapping("/repair-service/management/create-client-type")
    public String createClientTypePost(@ModelAttribute("clientType")
                                       @Valid ClientTypeDTO clientTypeDTO,
                                       BindingResult result){
        if (result.hasErrors()){
            return "/management";
        }
        repairService.saveClientType(clientTypeDTO);
        return "redirect:/repair-service/management";
    }

    @GetMapping("/repair-service/management/delete-client-type/{client_type_id}")
    public String deleteClientType(@PathVariable Long client_type_id){
        repairService.deleteClientType(client_type_id);
        return "redirect:/repair-service/management";
    }

    //----- Save\Delete Device

    @PostMapping("/repair-service/management/create-device")
    public String createDevicePost(@ModelAttribute("device")
                                   @Valid DeviceDTO deviceDTO,
                                   BindingResult result){
        if (result.hasErrors()){
            return "/management";
        }
        repairService.saveDevice(deviceDTO);
        return "redirect:/repair-service/management";
    }

    @GetMapping("/repair-service/management/delete-device/{device_id}")
    public String deleteDevice(@PathVariable Long device_id){
        repairService.deleteDevice(device_id);
        return "redirect:/repair-service/management";
    }

    //----- Save\Delete Repair Type

    @PostMapping("/repair-service/management/create-repair-type")
    public String createRepairTypePost(@ModelAttribute("repairType")
                                       @Valid RepairTypeDTO repairTypeDTO,
                                       BindingResult result){
        if (result.hasErrors()){
            return "/management";
        }
        repairService.saveRepairType(repairTypeDTO);
        return "redirect:/repair-service/management";
    }

    @GetMapping("/repair-service/management/delete-repair-type/{repair_type_id}")
    public String deleteRepairType(@PathVariable Long repair_type_id){
        repairService.deleteRepairType(repair_type_id);
        return "redirect:/repair-service/management";
    }

}
