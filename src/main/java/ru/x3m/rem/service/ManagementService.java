package ru.x3m.rem.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.x3m.rem.dto.*;
import ru.x3m.rem.entity.*;
import ru.x3m.rem.repository.*;
import ru.x3m.rem.utils.ObjectMapperUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

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

    public boolean existClientByName(String clientName) {
        return clientRepo.existsByClientName(clientName);
    }

    public ClientDTO findClientById(Long id) {
        Client client = clientRepo.findClientByClientId(id);
        return ObjectMapperUtils.map(client, ClientDTO.class);
    }

    public List<ClientDTO> findAllClients() {
        List<Client> clients = (List<Client>) clientRepo.findAll();
        return ObjectMapperUtils.mapAll(clients, ClientDTO.class);
    }

    public void saveClient(ClientDTO clientDTO) {
        Client client = ObjectMapperUtils.map(clientDTO, Client.class);
        clientRepo.save(client);

        String clientDir = client.getClientName();
        try {
            Files.createDirectories(Paths.get("/home/x3m/Downloads/rem/clientFiles/" + clientDir));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteClient(Long clientId) {
        clientRepo.findById(clientId)
                .ifPresent(clientRepo::delete);
    }

    //--- Client type
    public boolean existByClientTypeName(String clientTypeName) {
        return clientTypeRepo.existsByClientTypeName(clientTypeName);
    }

    public ClientTypeDTO findClientTypeById(Long id) {
        ClientType clientType = clientTypeRepo.findByClientTypeId(id);
        return ObjectMapperUtils.map(clientType, ClientTypeDTO.class);
    }

    public List<ClientTypeDTO> findAllClientTypes() {
        List<ClientType> clientTypes = (List<ClientType>) clientTypeRepo.findAll();
        return ObjectMapperUtils.mapAll(clientTypes, ClientTypeDTO.class);
    }

    public void saveClientType(ClientTypeDTO clientTypeDTO) {
        ClientType clientType = ObjectMapperUtils.map(clientTypeDTO, ClientType.class);
        clientTypeRepo.save(clientType);
    }

    public void deleteClientType(Long clientTypeId) {
        clientTypeRepo.findById(clientTypeId)
                .ifPresent(clientTypeRepo::delete);
    }

    //--- Device
    public boolean existByDeviceName(String deviceName) {
        return deviceRepo.existsByDeviceName(deviceName);
    }

    public DeviceDTO findDeviceById(Long id) {
        Optional<Device> device = deviceRepo.findById(id);
        return ObjectMapperUtils.map(device, DeviceDTO.class);
    }

    public List<DeviceDTO> findAllDevices() {
        List<Device> devices = (List<Device>) deviceRepo.findAll();
        return ObjectMapperUtils.mapAll(devices, DeviceDTO.class);
    }

    public void saveDevice(DeviceDTO deviceDTO) {
        Device device = ObjectMapperUtils.map(deviceDTO, Device.class);
        deviceRepo.save(device);

    }

    public void deleteDevice(Long deviceId) {
        deviceRepo.findById(deviceId)
                .ifPresent(deviceRepo::delete);
    }

    //--- Repair type
    public boolean existByRepairTypeName(String repairTypeName) {
        return repairTypeRepo.existsByRepairTypeName(repairTypeName);
    }

    public RepairTypeDTO findRepairTypeById(Long id) {
        RepairType repairType = repairTypeRepo.findByRepairTypeId(id);
        return ObjectMapperUtils.map(repairType, RepairTypeDTO.class);
    }

    public List<RepairTypeDTO> findAllRepairTypes() {
        List<RepairType> repairTypes = (List<RepairType>) repairTypeRepo.findAll();
        return ObjectMapperUtils.mapAll(repairTypes, RepairTypeDTO.class);
    }

    public void saveRepairType(RepairTypeDTO repairTypeDTO) {
        RepairType repairType = ObjectMapperUtils.map(repairTypeDTO, RepairType.class);
        repairTypeRepo.save(repairType);
    }

    public void deleteRepairType(Long repairTypeId) {
        repairTypeRepo.findById(repairTypeId)
                .ifPresent(repairTypeRepo::delete);
    }

    //--- Repair status
    public boolean existByStatusName(String statusName) {
        return repairStatusRepo.existsByStatusName(statusName);
    }

    public RepairStatusDTO findRepairStatusById(Long id) {
        Optional<RepairStatus> repairStatus = repairStatusRepo.findById(id);
        return ObjectMapperUtils.map(repairStatus, RepairStatusDTO.class);
    }

    public List<RepairStatusDTO> findAllRepairStatuses() {
        List<RepairStatus> repairStatuses = (List<RepairStatus>) repairStatusRepo.findAll();
        return ObjectMapperUtils.mapAll(repairStatuses, RepairStatusDTO.class);
    }

    public void saveStatus(RepairStatusDTO repairStatusDTO) {
        RepairStatus repairStatus = ObjectMapperUtils.map(repairStatusDTO, RepairStatus.class);
        repairStatusRepo.save(repairStatus);
    }

    public void deleteStatus(Long status_id) {
        repairStatusRepo.findById(status_id)
                .ifPresent(repairStatusRepo::delete);
    }

}
