package ru.x3m.rem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.x3m.rem.dto.*;
import ru.x3m.rem.service.ManagementService;

import java.util.List;

@RestController
@RequestMapping("/management/api")
public class ManagementRestController {

    private final ManagementService managementService;


    @Autowired
    public ManagementRestController(ManagementService managementService) {
        this.managementService = managementService;
    }

    @GetMapping("/findAllClients")
    public List<ClientDTO> findAllClients() {
        return managementService.findAllClients();
    }

    @GetMapping(value = "/findClient/{id}")
    @ResponseBody
    public ClientDTO findClient(@PathVariable("id") Long id) {
        return managementService.findClientById(id);
    }

    @GetMapping(value = "/findDevice/{id}")
    @ResponseBody
    public DeviceDTO findDevice(@PathVariable("id") Long id) {
        return managementService.findDeviceById(id);
    }

    @GetMapping(value = "/findRepairType/{id}")
    @ResponseBody
    public RepairTypeDTO findRepairType(@PathVariable("id") Long id) {
        return managementService.findRepairTypeById(id);
    }

    @GetMapping(value = "/findClientType/{id}")
    @ResponseBody
    public ClientTypeDTO findClientType(@PathVariable("id") Long id) {
        return managementService.findClientTypeById(id);
    }

    @GetMapping("/findStatus/{id}")
    public RepairStatusDTO findStatusById(@PathVariable("id") Long id) {
        return managementService.findRepairStatusById(id);
    }

}
