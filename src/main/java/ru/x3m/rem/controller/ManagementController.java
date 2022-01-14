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
import ru.x3m.rem.dto.*;
import ru.x3m.rem.entity.Client;
import ru.x3m.rem.entity.ClientType;
import ru.x3m.rem.entity.Device;
import ru.x3m.rem.entity.RepairType;
import ru.x3m.rem.service.ManagementService;
import ru.x3m.rem.service.RepairService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ManagementController {

    private ManagementService managementService;
    private RepairService repairService;

    @Autowired
    public ManagementController(ManagementService managementService, RepairService repairService) {
        this.managementService = managementService;
        this.repairService = repairService;
    }

    @GetMapping("/repair-service/management")
    public String managementPage(Model model){
        List<Client> clients = managementService.findAllClients();
        model.addAttribute("clients", clients);
        List<Device> devices = managementService.findAllDevices();
        model.addAttribute("devices", devices);
        List<ClientType> clientTypes = managementService.findAllClientTypes();
        model.addAttribute("clientTypes", clientTypes);
        List<RepairType> repairTypes = managementService.findAllRepairTypes();
        model.addAttribute("repairTypes", repairTypes);
        return "management";
    }

    @GetMapping("repair-service/management/client/{client_id}")
    public String clientPage(@PathVariable("client_id") Long client_id, Model model){
        ClientDTO clientDTO = managementService.findClientById(client_id)
                .orElseThrow(ResourceNotFoundException::new);
        model.addAttribute("client", clientDTO);
        return "client";
    }

    @GetMapping("/repair-service/management/client/create-client")
    public String createClientPage(Model model){
        model.addAttribute("client", new ClientDTO());
        return "client";
    }

    @PostMapping("/repair-service/management/client/create-client")
    public String createClientPost(@ModelAttribute("client") @Valid ClientDTO clientDTO,
                                   BindingResult result){
        if (result.hasErrors()){
            return "client";
        }
        managementService.saveClient(clientDTO);
        return "redirect:/repair-service/management/";
    }

    @GetMapping("/repair-service/management/client/delete-client/{client_id}")
    public String deleteClient(@PathVariable Long client_id){
        managementService.deleteClient(client_id);
        return "redirect:/repair-service/management/";
    }

    @GetMapping("repair-service/management/client-type/{client_type_id}")
    public String clientTypePage(@PathVariable("client_type_id") Long client_type_id, Model model){
        ClientTypeDTO clientTypeDTO = managementService.findClientTypeById(client_type_id)
                .orElseThrow(ResourceNotFoundException::new);
        model.addAttribute("clientType", clientTypeDTO);
        return "client-type";
    }

    @GetMapping("/repair-service/management/client-type/create-client-type")
    public String createClientTypePage(Model model){
        model.addAttribute("clientType", new ClientTypeDTO());
        return "client-type";
    }
    @PostMapping("/repair-service/management/client-type/create-client-type")
    public String createClientTypePost(@ModelAttribute("clientType")
                                   @Valid ClientTypeDTO clientTypeDTO,
                                   BindingResult result){
        if (result.hasErrors()){
            return "client-type";
        }
        managementService.saveClientType(clientTypeDTO);
        return "redirect:/repair-service/management/";
    }

    @GetMapping("/repair-service/management/client-type/delete-client-type/{client_type_id}")
    public String deleteClientType(@PathVariable Long client_type_id){
        managementService.deleteClientType(client_type_id);
        return "redirect:/repair-service/management/";
    }

    @GetMapping("repair-service/management/device/{device_id}")
    public String devicePage(@PathVariable("device_id") Long device_id, Model model){
        DeviceDTO deviceDTO = managementService.findDeviceById(device_id)
                .orElseThrow(ResourceNotFoundException::new);
        model.addAttribute("device", deviceDTO);
        return "device";
    }

    @GetMapping("/repair-service/management/device/create-device")
    public String createDevicePage(Model model){
        model.addAttribute("device", new DeviceDTO());
        return "device";
    }

    @PostMapping("/repair-service/management/device/create-device")
    public String createDevicePost(@ModelAttribute("device")
                                       @Valid DeviceDTO deviceDTO,
                                       BindingResult result){
        if (result.hasErrors()){
            return "device";
        }
        managementService.saveDevice(deviceDTO);
        return "redirect:/repair-service/management/";
    }

    @GetMapping("/repair-service/management/device/delete-device/{device_id}")
    public String deleteDevice(@PathVariable Long device_id){
        managementService.deleteDevice(device_id);
        return "redirect:/repair-service/management/";
    }

    @GetMapping("repair-service/management/repair-type/{repair_type_id}")
    public String repairTypePage(@PathVariable("repair_type_id") Long repair_type_id, Model model){
        RepairTypeDTO repairTypeDTO = managementService.findRepairTypeById(repair_type_id)
                .orElseThrow(ResourceNotFoundException::new);
        model.addAttribute("repairType", repairTypeDTO);
        return "repair-type";
    }

    @GetMapping("/repair-service/management/repair-type/create-repair-type")
    public String createRepairTypePage(Model model){
        model.addAttribute("repairType", new RepairTypeDTO());
        return "repair-type";
    }

    @PostMapping("/repair-service/management/repair-type/create-repair-type")
    public String createRepairTypePost(@ModelAttribute("repairType")
                                       @Valid RepairTypeDTO repairTypeDTO,
                                       BindingResult result){
        if (result.hasErrors()){
            return "repair-type";
        }
        managementService.saveRepairType(repairTypeDTO);
        return "redirect:/repair-service/management/";
    }

    @GetMapping("/repair-service/management/repair-type/delete-repair-type/{repair_type_id}")
    public String deleteRepairType(@PathVariable Long repair_type_id){
        managementService.deleteRepairType(repair_type_id);
        return "redirect:/repair-service/management/";
    }



}
