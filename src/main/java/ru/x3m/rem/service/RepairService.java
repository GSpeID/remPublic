package ru.x3m.rem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.x3m.rem.dto.RepairDTO;
import ru.x3m.rem.entity.Repair;
import ru.x3m.rem.repository.RepairRepo;

import java.util.List;

@Service
@Transactional
public class RepairService {

    private final RepairRepo repairRepo;


    @Autowired
    public RepairService(RepairRepo repairRepo) {
        this.repairRepo = repairRepo;
    }

    public Repair findRepairById(Long id) {
        return repairRepo.findByRepairId(id);
    }

    public List<Repair> findAllRepairs() {
        return (List<Repair>) repairRepo.findAll();
    }

    public void saveRepair(RepairDTO repairDTO) {
        Repair repair = new Repair();
        repair.setRepairId(repairDTO.getRepairId());
        repair.setRepairAddress(repairDTO.getRepairAddress());
        repair.setRepairDescription(repairDTO.getRepairDescription());
        repair.setRepairDate(repairDTO.getRepairDate());
        repair.setDeviceId(repairDTO.getDeviceId());
        repair.setClientId(repairDTO.getClientId());
        repair.setRepairTypeId(repairDTO.getRepairTypeId());
        repair.setStatusId(repairDTO.getStatusId());
        repair.setFullCost(repairDTO.getFullCost());
        repair.setPaid(repairDTO.getPaid());
        repair.setArrears(repairDTO.calcArrears());
        repair.setOutlay(repairDTO.getOutlay());
        repair.setProfit(repairDTO.calcProfit());
        repair.setCash(repairDTO.getCash());
        repairRepo.save(repair);
    }

    public void deleteRepair(Long repair_id){
        repairRepo.findById(repair_id)
                .ifPresent(repairRepo::delete);
    }

}
