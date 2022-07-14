package ru.x3m.rem.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.x3m.rem.dto.*;
import ru.x3m.rem.entity.*;
import ru.x3m.rem.repository.*;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ManagementService {

    private ClientRepo clientRepo;
    private ClientTypeRepo clientTypeRepo;
    private DeviceRepo deviceRepo;
    private RepairTypeRepo repairTypeRepo;
    private RepairStatusesRepo repairStatusesRepo;

    @Autowired
    public ManagementService(ClientRepo clientRepo, ClientTypeRepo clientTypeRepo,
                             DeviceRepo deviceRepo, RepairTypeRepo repairTypeRepo,
                             RepairStatusesRepo repairStatusesRepo) {
        this.clientRepo = clientRepo;
        this.clientTypeRepo = clientTypeRepo;
        this.deviceRepo = deviceRepo;
        this.repairTypeRepo = repairTypeRepo;
        this.repairStatusesRepo = repairStatusesRepo;
    }

    public Optional<ClientDTO> findClientById(Long clientId){
        return clientRepo.findById(clientId)
                .map(ClientDTO::new);
    }

    public String findClientByName(String clientName){
        return clientName;
    }

    public List<Client> findAllClients(){
        return (List<Client>) clientRepo.findAll();
    }

    public Optional<ClientTypeDTO> findClientTypeById(Long clientId){
        return clientTypeRepo.findById(clientId)
                .map(ClientTypeDTO::new);
    }

    public List<ClientType> findAllClientTypes(){
        return (List<ClientType>) clientTypeRepo.findAll();
    }

    public Optional<DeviceDTO> findDeviceById(Long deviceId){
        return deviceRepo.findById(deviceId)
                .map(DeviceDTO::new);
    }

    public List<Device> findAllDevices(){
        return (List<Device>) deviceRepo.findAll();
    }

    public Optional<RepairTypeDTO> findRepairTypeById(Long repairTypeId){
        return repairTypeRepo.findById(repairTypeId)
                .map(RepairTypeDTO::new);
    }

    public List<RepairType> findAllRepairTypes(){
        return (List<RepairType>) repairTypeRepo.findAll();
    }

    public Optional<RepairStatusDTO> findRepairStatusById(Long statusId){
        return repairStatusesRepo.findById(statusId)
                .map(RepairStatusDTO::new);
    }

    public List<RepairStatuses> findAllRepairStatuses(){
        return (List<RepairStatuses>) repairStatusesRepo.findAll();
    }

    public void saveClient(ClientDTO clientDTO){
        Client client = new Client();
        client.setClientId(clientDTO.getClientId());
        client.setClientName(clientDTO.getClientName());
        client.setClientTypeId(clientDTO.getClientTypeId());

        clientRepo.save(client);
    }

    public void deleteClient(Long clientId){
        clientRepo.findById(clientId)
                .ifPresent(client -> clientRepo.delete(client));
    }

    public void saveClientType(ClientTypeDTO clientTypeDTO){
        ClientType clientType = new ClientType();
        clientType.setClientTypeId(clientTypeDTO.getClientTypeId());
        clientType.setClientTypeName(clientTypeDTO.getClientTypeName());

        clientTypeRepo.save(clientType);
    }

    public void deleteClientType(Long clientTypeId){
        clientTypeRepo.findById(clientTypeId)
                .ifPresent(clientType -> clientTypeRepo.delete(clientType));
    }

    public void saveDevice(DeviceDTO deviceDTO){
        Device device = new Device();
        device.setDeviceId(deviceDTO.getDeviceId());
        device.setDeviceName(deviceDTO.getDeviceName());

        deviceRepo.save(device);

    }

    public void deleteDevice(Long deviceId){
        deviceRepo.findById(deviceId)
                .ifPresent(device -> deviceRepo.delete(device));
    }

    public void saveRepairType(RepairTypeDTO repairTypeDTO){
        RepairType repairType = new RepairType();
        repairType.setRepairTypeId(repairTypeDTO.getRepairTypeId());
        repairType.setRepairTypeName(repairTypeDTO.getRepairTypeName());

        repairTypeRepo.save(repairType);
    }

    public void deleteRepairType(Long repairTypeId){
        repairTypeRepo.findById(repairTypeId)
                .ifPresent(repairType -> repairTypeRepo.delete(repairType));
    }


    public  void saveStatus(RepairStatusDTO repairStatusDTO){
        RepairStatuses repairStatus = new RepairStatuses();
        repairStatus.setStatusId(repairStatusDTO.getStatusId());
        repairStatus.setStatusName(repairStatusDTO.getStatusName());

        repairStatusesRepo.save(repairStatus);
    }

    public void deleteStatus(Long status_id){
        repairStatusesRepo.findById(status_id)
                .ifPresent(repairStatuses -> repairStatusesRepo.delete(repairStatuses));
    }

}
