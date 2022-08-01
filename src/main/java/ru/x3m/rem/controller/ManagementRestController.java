package ru.x3m.rem.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.x3m.rem.dto.*;
import ru.x3m.rem.entity.Client;
import ru.x3m.rem.service.ManagementService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping("/repair-service/management/api")
public class ManagementRestController {

    private final ManagementService managementService;

    private final ModelMapper modelMapper;

    @Autowired
    public ManagementRestController(ManagementService managementService, ModelMapper modelMapper) {
        this.managementService = managementService;
        this.modelMapper = modelMapper;
    }

    @GetMapping(value = "/findClient/{id}")
    @ResponseBody
    public ClientDTO findClient(@PathVariable("id") Long id) {
        return convertToDto(managementService.findClientById(id));
    }

    @RequestMapping(value = "/findDevice/{deviceId}", method = RequestMethod.GET)
    public Optional<DeviceDTO> getDeviceByIdRest(HttpServletRequest request,
                                                 @PathVariable("deviceId") Long deviceId) {
        return managementService.findDeviceById(deviceId);
    }

    @RequestMapping(value = "/findRepairType/{repairTypeId}", method = RequestMethod.GET)
    public Optional<RepairTypeDTO> getRepairTypeByIdRest(HttpServletRequest request,
                                                         @PathVariable("repairTypeId") Long repairTypeId){
        return managementService.findRepairTypeById(repairTypeId);
    }

    @RequestMapping(value = "/findClientType/{clientTypeId}", method = RequestMethod.GET)
    public Optional<ClientTypeDTO> getClientTypeByIdRest(HttpServletRequest request,
                                                         @PathVariable("clientTypeId") Long clientTypeId) {
        return managementService.findClientTypeById(clientTypeId);
    }

    @RequestMapping(value = "/findStatus/{statusId}", method = RequestMethod.GET)
    public Optional<RepairStatusDTO> getStatusByIdRest(HttpServletRequest request,
                                                       @PathVariable("statusId") Long statusId) {
        return managementService.findRepairStatusById(statusId);
    }

    private ClientDTO convertToDto(Client client) {
        return modelMapper.map(client, ClientDTO.class);
    }

    //--- DTO to entity
    private Client convertToEntity(ClientDTO clientDTO) {
        return modelMapper.map(clientDTO, Client.class);
    }


}
