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

    private final ClientRepo clientRepo;
    private final ClientTypeRepo clientTypeRepo;
    private final DeviceRepo deviceRepo;
    private final RepairTypeRepo repairTypeRepo;
    private final RepairStatusesRepo repairStatusesRepo;

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


    //--- Clients
    public Optional<ClientDTO> findClientById(Long clientId){
        return clientRepo.findById(clientId)
                .map(ClientDTO::new);
    }

    public List<Client> findAllClients(){
        return (List<Client>) clientRepo.findAll();
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
                .ifPresent(clientRepo::delete);
    }

    //--- Client type
    public Optional<ClientTypeDTO> findClientTypeById(Long clientId){
        return clientTypeRepo.findById(clientId)
                .map(ClientTypeDTO::new);
    }

    public List<ClientType> findAllClientTypes(){
        return (List<ClientType>) clientTypeRepo.findAll();
    }

    public void saveClientType(ClientTypeDTO clientTypeDTO){
        ClientType clientType = new ClientType();
        clientType.setClientTypeId(clientTypeDTO.getClientTypeId());
        clientType.setClientTypeName(clientTypeDTO.getClientTypeName());
        clientTypeRepo.save(clientType);
    }

    public void deleteClientType(Long clientTypeId){
        clientTypeRepo.findById(clientTypeId)
                .ifPresent(clientTypeRepo::delete);
    }

    //--- Device
    public Optional<DeviceDTO> findDeviceById(Long deviceId){
        return deviceRepo.findById(deviceId)
                .map(DeviceDTO::new);
    }

    public List<Device> findAllDevices(){
        return (List<Device>) deviceRepo.findAll();
    }

    public void saveDevice(DeviceDTO deviceDTO){
        Device device = new Device();
        device.setDeviceId(deviceDTO.getDeviceId());
        device.setDeviceName(deviceDTO.getDeviceName());
        deviceRepo.save(device);

    }

    public void deleteDevice(Long deviceId){
        deviceRepo.findById(deviceId)
                .ifPresent(deviceRepo::delete);
    }

    //--- Repair type
    public Optional<RepairTypeDTO> findRepairTypeById(Long repairTypeId){
        return repairTypeRepo.findById(repairTypeId)
                .map(RepairTypeDTO::new);
    }

    public List<RepairType> findAllRepairTypes(){
        return (List<RepairType>) repairTypeRepo.findAll();
    }

    public void saveRepairType(RepairTypeDTO repairTypeDTO){
        RepairType repairType = new RepairType();
        repairType.setRepairTypeId(repairTypeDTO.getRepairTypeId());
        repairType.setRepairTypeName(repairTypeDTO.getRepairTypeName());
        repairTypeRepo.save(repairType);
    }

    public void deleteRepairType(Long repairTypeId){
        repairTypeRepo.findById(repairTypeId)
                .ifPresent(repairTypeRepo::delete);
    }

    //--- Repair status
    public Optional<RepairStatusDTO> findRepairStatusById(Long statusId){
        return repairStatusesRepo.findById(statusId)
                .map(RepairStatusDTO::new);
    }

    public List<RepairStatuses> findAllRepairStatuses(){
        return (List<RepairStatuses>) repairStatusesRepo.findAll();
    }

    public  void saveStatus(RepairStatusDTO repairStatusDTO){
        RepairStatuses repairStatus = new RepairStatuses();
        repairStatus.setStatusId(repairStatusDTO.getStatusId());
        repairStatus.setStatusName(repairStatusDTO.getStatusName());
        repairStatusesRepo.save(repairStatus);
    }

    public void deleteStatus(Long status_id){
        repairStatusesRepo.findById(status_id)
                .ifPresent(repairStatusesRepo::delete);
    }

}
