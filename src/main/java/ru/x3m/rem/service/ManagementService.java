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

    public Optional<ClientDTO> findClientById(Long client_id){
        return clientRepo.findById(client_id)
                .map(ClientDTO::new);
    }

    public String findClientByName(String client_name){
        return client_name;
    }

    public List<Client> findAllClients(){
        return (List<Client>) clientRepo.findAll();
    }

    public Optional<ClientTypeDTO> findClientTypeById(Long client_id){
        return clientTypeRepo.findById(client_id)
                .map(ClientTypeDTO::new);
    }

    public List<ClientType> findAllClientTypes(){
        return (List<ClientType>) clientTypeRepo.findAll();
    }

    public Optional<DeviceDTO> findDeviceById(Long device_id){
        return deviceRepo.findById(device_id)
                .map(DeviceDTO::new);
    }

    public List<Device> findAllDevices(){
        return (List<Device>) deviceRepo.findAll();
    }

    public Optional<RepairTypeDTO> findRepairTypeById(Long repair_type_id){
        return repairTypeRepo.findById(repair_type_id)
                .map(RepairTypeDTO::new);
    }

    public List<RepairType> findAllRepairTypes(){
        return (List<RepairType>) repairTypeRepo.findAll();
    }

    public Optional<RepairStatusDTO> findRepairStatusById(Long status_id){
        return repairStatusesRepo.findById(status_id)
                .map(RepairStatusDTO::new);
    }

    public List<RepairStatuses> findAllRepairStatuses(){
        return (List<RepairStatuses>) repairStatusesRepo.findAll();
    }

    public void saveClient(ClientDTO clientDTO){
        Client client = new Client();
        client.setClient_id(clientDTO.getClient_id());
        client.setClient_name(clientDTO.getClient_name());
        client.setClient_type_id(clientDTO.getClient_type_id());

        clientRepo.save(client);
    }

    public void deleteClient(Long client_id){
        clientRepo.findById(client_id)
                .ifPresent(client -> clientRepo.delete(client));
    }

    public void saveClientType(ClientTypeDTO clientTypeDTO){
        ClientType clientType = new ClientType();
        clientType.setClient_type_id(clientTypeDTO.getClient_type_id());
        clientType.setClient_type_name(clientTypeDTO.getClient_type_name());

        clientTypeRepo.save(clientType);
    }

    public void deleteClientType(Long client_type_id){
        clientTypeRepo.findById(client_type_id)
                .ifPresent(clientType -> clientTypeRepo.delete(clientType));
    }

    public void saveDevice(DeviceDTO deviceDTO){
        Device device = new Device();
        device.setDevice_id(deviceDTO.getDevice_id());
        device.setDevice_name(deviceDTO.getDevice_name());

        deviceRepo.save(device);

    }

    public void deleteDevice(Long device_id){
        deviceRepo.findById(device_id)
                .ifPresent(device -> deviceRepo.delete(device));
    }

    public void saveRepairType(RepairTypeDTO repairTypeDTO){
        RepairType repairType = new RepairType();
        repairType.setRepair_type_id(repairTypeDTO.getRepair_type_id());
        repairType.setRepair_type_name(repairTypeDTO.getRepair_type_name());

        repairTypeRepo.save(repairType);
    }

    public void deleteRepairType(Long repair_type_id){
        repairTypeRepo.findById(repair_type_id)
                .ifPresent(repairType -> repairTypeRepo.delete(repairType));
    }


    public  void saveStatus(RepairStatusDTO repairStatusDTO){
        RepairStatuses repairStatus = new RepairStatuses();
        repairStatus.setStatus_id(repairStatusDTO.getStatus_id());
        repairStatus.setStatus_name(repairStatusDTO.getStatus_name());

        repairStatusesRepo.save(repairStatus);
    }

    public void deleteStatus(Long status_id){
        repairStatusesRepo.findById(status_id)
                .ifPresent(repairStatuses -> repairStatusesRepo.delete(repairStatuses));
    }

    public ClientRepo getClientRepo() {
        return clientRepo;
    }

    public void setClientRepo(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    public ClientTypeRepo getClientTypeRepo() {
        return clientTypeRepo;
    }

    public void setClientTypeRepo(ClientTypeRepo clientTypeRepo) {
        this.clientTypeRepo = clientTypeRepo;
    }

    public DeviceRepo getDeviceRepo() {
        return deviceRepo;
    }

    public void setDeviceRepo(DeviceRepo deviceRepo) {
        this.deviceRepo = deviceRepo;
    }

    public RepairTypeRepo getRepairTypeRepo() {
        return repairTypeRepo;
    }

    public void setRepairTypeRepo(RepairTypeRepo repairTypeRepo) {
        this.repairTypeRepo = repairTypeRepo;
    }

    public RepairStatusesRepo getRepairStatusesRepo() {
        return repairStatusesRepo;
    }

    public void setRepairStatusesRepo(RepairStatusesRepo repairStatusesRepo) {
        this.repairStatusesRepo = repairStatusesRepo;
    }

}
