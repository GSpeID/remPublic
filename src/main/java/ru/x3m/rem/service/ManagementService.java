package ru.x3m.rem.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.x3m.rem.dto.*;
import ru.x3m.rem.entity.*;
import ru.x3m.rem.repository.*;

import java.util.List;

@Service
@Transactional
public class ManagementService {

    private final ClientRepo clientRepo;
    private final ClientTypeRepo clientTypeRepo;
    private final DeviceRepo deviceRepo;
    private final RepairTypeRepo repairTypeRepo;
    private final RepairStatusRepo repairStatusRepo;

    @Autowired
    public ManagementService(ClientRepo clientRepo, ClientTypeRepo clientTypeRepo,
                             DeviceRepo deviceRepo, RepairTypeRepo repairTypeRepo,
                             RepairStatusRepo repairStatusRepo) {
        this.clientRepo = clientRepo;
        this.clientTypeRepo = clientTypeRepo;
        this.deviceRepo = deviceRepo;
        this.repairTypeRepo = repairTypeRepo;
        this.repairStatusRepo = repairStatusRepo;
    }


    //--- Clients
    public Client findClientById(Long id) {
        return clientRepo.findClientByClientId(id);
    }

    public List<Client> findAllClients(){
        return (List<Client>) clientRepo.findAll();
    }

    public void saveClient(ClientDTO clientDTO) {
        Client client = new Client();
        client.setClientId(clientDTO.getClientId());
        client.setClientName(clientDTO.getClientName());
        client.setClientTypeId(clientDTO.getClientTypeId());
        client.setClientContact(clientDTO.getClientContact());
        client.setClientPhone(clientDTO.getClientPhone());
        client.setClientMail(clientDTO.getClientMail());
        clientRepo.save(client);
    }

    public void deleteClient(Long clientId){
        clientRepo.findById(clientId)
                .ifPresent(clientRepo::delete);
    }

    //--- Client type
    public ClientType findClientTypeById(Long id) {
        return clientTypeRepo.findByClientTypeId(id);
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
    public Device findDeviceById(Long id) {
        return deviceRepo.findByDeviceId(id);
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
    public RepairType findRepairTypeById(Long id) {
        return repairTypeRepo.findByRepairTypeId(id);
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

    public void deleteRepairType(Long repairTypeId) {
        repairTypeRepo.findById(repairTypeId)
                .ifPresent(repairTypeRepo::delete);
    }

    //--- Repair status
    public RepairStatus findRepairStatusById(Long id) {
        return repairStatusRepo.findByStatusId(id);
    }

    public List<RepairStatus> findAllRepairStatuses() {
        return (List<RepairStatus>) repairStatusRepo.findAll();
    }

    public void saveStatus(RepairStatusDTO repairStatusDTO) {
        RepairStatus repairStatus = new RepairStatus();
        repairStatus.setStatusId(repairStatusDTO.getStatusId());
        repairStatus.setStatusName(repairStatusDTO.getStatusName());
        repairStatusRepo.save(repairStatus);
    }

    public void deleteStatus(Long status_id) {
        repairStatusRepo.findById(status_id)
                .ifPresent(repairStatusRepo::delete);
    }

}
