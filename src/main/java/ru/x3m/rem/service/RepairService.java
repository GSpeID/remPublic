package ru.x3m.rem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.x3m.rem.dto.RepairDTO;
import ru.x3m.rem.entity.Repair;
import ru.x3m.rem.repository.RepairRepo;
import ru.x3m.rem.utils.ObjectMapperUtils;

import java.util.List;

@Service
@Transactional
public class RepairService {

    private final RepairRepo repairRepo;


    @Autowired
    public RepairService(RepairRepo repairRepo) {
        this.repairRepo = repairRepo;
    }

    public List<RepairDTO> findAllRepairs() {
        List<Repair> repairs = (List<Repair>) repairRepo.findAll();
        return ObjectMapperUtils.mapAll(repairs, RepairDTO.class);
    }

    public RepairDTO findRepairById(Long id) {
        Repair repair = repairRepo.findByRepairId(id);
        return ObjectMapperUtils.map(repair, RepairDTO.class);
    }

    public void saveRepair(RepairDTO repairDTO) {
        Repair repair = ObjectMapperUtils.map(repairDTO, Repair.class);
        repairRepo.save(repair);
    }

    public void deleteRepair(Long repair_id) {
        repairRepo.findById(repair_id)
                .ifPresent(repairRepo::delete);
    }

}
