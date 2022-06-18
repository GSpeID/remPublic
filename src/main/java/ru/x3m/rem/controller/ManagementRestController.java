package ru.x3m.rem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.x3m.rem.dto.*;
import ru.x3m.rem.service.ManagementService;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping("/repair-service/management/api")
public class ManagementRestController {

    private ManagementService managementService;

    @Autowired
    public ManagementRestController(ManagementService managementService) {
        this.managementService = managementService;
    }

    @RequestMapping(value = "/findClient/{client_id}", method = RequestMethod.GET)
    public Optional<ClientDTO> getClientByIdRest(HttpServletRequest request,
                                                 @PathVariable("client_id") Long client_id){
        return managementService.findClientById(client_id);
    }

    @RequestMapping(value = "/findDevice/{device_id}", method = RequestMethod.GET)
    public Optional<DeviceDTO> getDeviceByIdRest(HttpServletRequest request,
                                                 @PathVariable("device_id") Long device_id){
        return managementService.findDeviceById(device_id);
    }

    @RequestMapping(value = "/findRepairType/{repair_type_id}",  method = RequestMethod.GET)
    public Optional<RepairTypeDTO> getRepairTypeByIdRest(HttpServletRequest request,
                                                         @PathVariable("repair_type_id") Long repair_type_id){
        return managementService.findRepairTypeById(repair_type_id);
    }

    @RequestMapping(value = "/findClientType/{client_type_id}", method = RequestMethod.GET)
    public Optional<ClientTypeDTO> getClientTypeByIdRest(HttpServletRequest request,
                                                         @PathVariable("client_type_id") Long client_type_id){
        return managementService.findClientTypeById(client_type_id);
    }

    @RequestMapping(value = "/findClientByName", method = RequestMethod.GET)
    public String getClientByNameRest(HttpServletRequest request,
                                      @PathVariable("client_name") String client_name){
        return  managementService.findClientByName(client_name);
    }

    @RequestMapping(value = "/findStatus/{status_id}", method = RequestMethod.GET)
    public Optional<RepairStatusDTO> getStatusByIdRest(HttpServletRequest request,
                                                         @PathVariable("status_id") Long status_id){
        return managementService.findRepairStatusById(status_id);
    }


}
