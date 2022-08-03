package ru.x3m.rem.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.x3m.rem.dto.*;
import ru.x3m.rem.entity.*;
import ru.x3m.rem.service.ManagementService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/management/api")
public class ManagementRestController {

    private final ManagementService managementService;

    private final ModelMapper modelMapper;

    @Autowired
    public ManagementRestController(ManagementService managementService, ModelMapper modelMapper) {
        this.managementService = managementService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/findAllClients")
    public List<ClientDTO> findAllClients() {
        List<Client> clients = managementService.findAllClients();
        return clients.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/findClient/{id}")
    @ResponseBody
    public ClientDTO findClient(@PathVariable("id") Long id) {
        return convertToDto(managementService.findClientById(id));
    }

    @GetMapping(value = "/findDevice/{id}")
    @ResponseBody
    public DeviceDTO findDevice(@PathVariable("id") Long id) {
        return convertToDto(managementService.findDeviceById(id));
    }

    @GetMapping(value = "/findRepairType/{id}")
    @ResponseBody
    public RepairTypeDTO findRepairType(@PathVariable("id") Long id) {
        return convertToDto(managementService.findRepairTypeById(id));
    }

    @GetMapping(value = "/findClientType/{id}")
    @ResponseBody
    public ClientTypeDTO findClientType(@PathVariable("id") Long id) {
        return convertToDto(managementService.findClientTypeById(id));
    }

    @GetMapping("/findStatus/{id}")
    public RepairStatusDTO findStatusById(@PathVariable("id") Long id) {
        return convertToDto(managementService.findRepairStatusById(id));
    }

    //--- entity to DTO
    private ClientDTO convertToDto(Client client) {
        return modelMapper.map(client, ClientDTO.class);
    }

    private RepairStatusDTO convertToDto(RepairStatus repairStatus) {
        return modelMapper.map(repairStatus, RepairStatusDTO.class);
    }

    private DeviceDTO convertToDto(Device device) {
        return modelMapper.map(device, DeviceDTO.class);
    }

    private RepairTypeDTO convertToDto(RepairType repairType) {
        return modelMapper.map(repairType, RepairTypeDTO.class);
    }

    private ClientTypeDTO convertToDto(ClientType clientType) {
        return modelMapper.map(clientType, ClientTypeDTO.class);
    }

    //--- DTO to entity
    private Client convertToEntity(ClientDTO clientDTO) {
        return modelMapper.map(clientDTO, Client.class);
    }


}
