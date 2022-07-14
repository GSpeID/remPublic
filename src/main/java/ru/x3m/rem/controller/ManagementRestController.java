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

    @RequestMapping(value = "/findClient/{clientId}", method = RequestMethod.GET)
    public Optional<ClientDTO> getClientByIdRest(HttpServletRequest request,
                                                 @PathVariable("clientId") Long clientId){
        return managementService.findClientById(clientId);
    }

    @RequestMapping(value = "/findDevice/{deviceId}", method = RequestMethod.GET)
    public Optional<DeviceDTO> getDeviceByIdRest(HttpServletRequest request,
                                                 @PathVariable("deviceId") Long deviceId){
        return managementService.findDeviceById(deviceId);
    }

    @RequestMapping(value = "/findRepairType/{repairTypeId}",  method = RequestMethod.GET)
    public Optional<RepairTypeDTO> getRepairTypeByIdRest(HttpServletRequest request,
                                                         @PathVariable("repairTypeId") Long repairTypeId){
        return managementService.findRepairTypeById(repairTypeId);
    }

    @RequestMapping(value = "/findClientType/{clientTypeId}", method = RequestMethod.GET)
    public Optional<ClientTypeDTO> getClientTypeByIdRest(HttpServletRequest request,
                                                         @PathVariable("clientTypeId") Long clientTypeId){
        return managementService.findClientTypeById(clientTypeId);
    }

    @RequestMapping(value = "/findStatus/{statusId}", method = RequestMethod.GET)
    public Optional<RepairStatusDTO> getStatusByIdRest(HttpServletRequest request,
                                                         @PathVariable("statusId") Long statusId){
        return managementService.findRepairStatusById(statusId);
    }


}
