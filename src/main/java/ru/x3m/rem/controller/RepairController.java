package ru.x3m.rem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.x3m.rem.controller.exeption.ResourceNotFoundException;
import ru.x3m.rem.dto.*;
import ru.x3m.rem.entity.*;
import ru.x3m.rem.service.RepairService;

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
    public String repairPage(){
        return "redirect:/repair-service/all";
    }

    @GetMapping("/repair-service/all")
    public String allRepairsPage(Model model){
        List<Repair> repairs = repairService.findAllRepairs();
        model.addAttribute("repairs", repairs);
        return "repair-list";
    }

    @GetMapping("/repair-service/{repair_id}")
    public String repairPage(@PathVariable("repair_id") Long repair_service_id, Model model){
        RepairDTO repairDTO = repairService.findRepairById(repair_service_id)
                .orElseThrow(ResourceNotFoundException::new);
        model.addAttribute("repair", repairDTO);
        return "repair";
    }

    @GetMapping("/repair-service/create")
    public String createService(Model model){
        model.addAttribute("repair", new RepairDTO());
        return "repair";
    }

    @PostMapping("/repair-service/create")
    public String createRepairPost(@ModelAttribute("repair")@Valid RepairDTO repairDTO,
                                   BindingResult result){
        if (result.hasErrors()){
            return "repair";
        }

        repairService.saveRepair(repairDTO);
        return "redirect:/repair-service";
    }

    @GetMapping("/repair-service/delete/{repair_id}")
    public String deleteRepair(@PathVariable Long repair_id){
        repairService.deleteRepair(repair_id);
        return "redirect:/repair-service/management";
    }


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
        return "management";
    }

    @GetMapping("/repair-service/management/client/{client_id}")
    public String clientPage(@PathVariable("client_id") Long client_id, Model model){
        ClientDTO clientDTO = repairService.findClientById(client_id)
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
        repairService.saveClient(clientDTO);
        return "redirect:/repair-service/management";
    }

    @GetMapping("/repair-service/management/client/delete-client/{client_id}")
    public String deleteClient(@PathVariable Long client_id){
        repairService.deleteClient(client_id);
        return "redirect:/repair-service/management/";
    }

    @GetMapping("repair-service/management/client-type/{client_type_id}")
    public String clientTypePage(@PathVariable("client_type_id") Long client_type_id, Model model){
        ClientTypeDTO clientTypeDTO = repairService.findClientTypeById(client_type_id)
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
        repairService.saveClientType(clientTypeDTO);
        return "redirect:/repair-service/management/";
    }

    @GetMapping("/repair-service/management/client-type/delete-client-type/{client_type_id}")
    public String deleteClientType(@PathVariable Long client_type_id){
        repairService.deleteClientType(client_type_id);
        return "redirect:/repair-service/management/";
    }

    @GetMapping("repair-service/management/device/{device_id}")
    public String devicePage(@PathVariable("device_id") Long device_id, Model model){
        DeviceDTO deviceDTO = repairService.findDeviceById(device_id)
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
        repairService.saveDevice(deviceDTO);
        return "redirect:/repair-service/management/";
    }

    @GetMapping("/repair-service/management/device/delete-device/{device_id}")
    public String deleteDevice(@PathVariable Long device_id){
        repairService.deleteDevice(device_id);
        return "redirect:/repair-service/management/";
    }

    @GetMapping("repair-service/management/repair-type/{repair_type_id}")
    public String repairTypePage(@PathVariable("repair_type_id") Long repair_type_id, Model model){
        RepairTypeDTO repairTypeDTO = repairService.findRepairTypeById(repair_type_id)
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
        repairService.saveRepairType(repairTypeDTO);
        return "redirect:/repair-service/management/";
    }

    @GetMapping("/repair-service/management/repair-type/delete-repair-type/{repair_type_id}")
    public String deleteRepairType(@PathVariable Long repair_type_id){
        repairService.deleteRepairType(repair_type_id);
        return "redirect:/repair-service/management/";
    }






}
