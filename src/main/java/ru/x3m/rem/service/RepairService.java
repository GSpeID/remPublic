package ru.x3m.rem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.x3m.rem.dto.*;
import ru.x3m.rem.entity.Repair;
import ru.x3m.rem.repository.RepairRepo;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RepairService {

    private RepairRepo repairRepo;

    @Autowired
    public RepairService(RepairRepo repairRepo) {
        this.repairRepo = repairRepo;
    }

    public Optional<RepairDTO> findRepairById(Long id){
        return repairRepo.findById(id)
                .map(RepairDTO::new);
    }

    public List<Repair> findAllRepairs() {
        return (List<Repair>) repairRepo.findAll();
    }

    public RepairRepo getRepairRepo() {
        return repairRepo;
    }

    public void setRepairRepo(RepairRepo repairRepo) {
        this.repairRepo = repairRepo;
    }

    public void saveRepair(RepairDTO repairDTO){
        Repair repair = new Repair();
        repair.setRepair_id(repairDTO.getRepair_id());
        repair.setRepair_name(repairDTO.getRepair_name());
        repair.setRepair_description(repairDTO.getRepair_description());
        repair.setRepair_cost(repairDTO.getRepair_cost());
        repair.setRepair_date(repairDTO.getRepair_date());

        repairRepo.save(repair);

    }

    public void deleteRepair(Long repair_id){
        repairRepo.findById(repair_id)
                .ifPresent(repair -> repairRepo.delete(repair));
    }



}
