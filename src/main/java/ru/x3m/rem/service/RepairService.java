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
public class RepairService {

    private RepairRepo repairRepo;
    private ClientRepo clientRepo;
    private ClientTypeRepo clientTypeRepo;
    private DeviceRepo deviceRepo;
    private RepairTypeRepo repairTypeRepo;
    private RepairStatusesRepo repairStatusesRepo;

    @Autowired
    public RepairService(RepairRepo repairRepo, ClientRepo clientRepo, ClientTypeRepo clientTypeRepo,
                         DeviceRepo deviceRepo, RepairTypeRepo repairTypeRepo,
                         RepairStatusesRepo repairStatusesRepo) {
        this.repairRepo = repairRepo;
        this.clientRepo = clientRepo;
        this.clientTypeRepo = clientTypeRepo;
        this.deviceRepo = deviceRepo;
        this.repairTypeRepo = repairTypeRepo;
        this.repairStatusesRepo = repairStatusesRepo;
    }

    public Optional<RepairDTO> findRepairById(Long id){
        return repairRepo.findById(id)
                .map(RepairDTO::new);
    }

    public List<Repair> findAllRepairs() {
        return (List<Repair>) repairRepo.findAll();
    }

    public void saveRepair(RepairDTO repairDTO){
        Repair repair = new Repair();
        repair.setRepair_id(repairDTO.getRepair_id());
        repair.setRepair_address(repairDTO.getRepair_address());
        repair.setRepair_description(repairDTO.getRepair_description());
        repair.setRepair_date(repairDTO.getRepair_date());
        repair.setDevice_id(repairDTO.getDevice_id());
        repair.setClient_id(repairDTO.getClient_id());
        repair.setRepair_type_id(repairDTO.getRepair_type_id());
        repair.setStatus_id(repairDTO.getStatus_id());
        repair.setFull_cost(repairDTO.getFull_cost());
        repair.setPaid(repairDTO.getPaid());
        repair.setArrears(repairDTO.calcArrears());
        repair.setOutlay(repairDTO.getOutlay());
        repair.setProfit(repairDTO.calcProfit());

        repairRepo.save(repair);

    }

    public void deleteRepair(Long repair_id){
        repairRepo.findById(repair_id)
                .ifPresent(repair -> repairRepo.delete(repair));
    }

    public RepairRepo getRepairRepo() {
        return repairRepo;
    }

    public void setRepairRepo(RepairRepo repairRepo) {
        this.repairRepo = repairRepo;
    }


}
