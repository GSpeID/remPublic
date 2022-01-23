package ru.x3m.rem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.x3m.rem.dto.*;
import ru.x3m.rem.service.RepairService;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping("/repair-service/management/api")
public class ManagementRestController {

    private RepairService repairService;

    @Autowired
    public ManagementRestController(RepairService repairService) {
        this.repairService = repairService;
    }

    @RequestMapping(value = "/findClient/{client_id}", method = RequestMethod.GET)
    public Optional<ClientDTO> getClientByIdRest(HttpServletRequest request,
                                                 @PathVariable("client_id") Long client_id){
        return repairService.findClientById(client_id);
    }

    @RequestMapping(value = "/findDevice/{device_id}", method = RequestMethod.GET)
    public Optional<DeviceDTO> getDeviceByIdRest(HttpServletRequest request,
                                                 @PathVariable("device_id") Long device_id){
        return repairService.findDeviceById(device_id);
    }

    @RequestMapping(value = "/findRepairType/{repair_type_id}",  method = RequestMethod.GET)
    public Optional<RepairTypeDTO> getRepairTypeByIdRest(HttpServletRequest request,
                                                         @PathVariable("repair_type_id") Long repair_type_id){
        return repairService.findRepairTypeById(repair_type_id);
    }

    @RequestMapping(value = "/findClientType/{client_type_id}", method = RequestMethod.GET)
    public Optional<ClientTypeDTO> getClientTypeByIdRest(HttpServletRequest request,
                                                         @PathVariable("client_type_id") Long client_type_id){
        return repairService.findClientTypeById(client_type_id);
    }


}
