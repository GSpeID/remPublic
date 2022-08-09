package ru.x3m.rem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.x3m.rem.dto.RepairDTO;
import ru.x3m.rem.service.RepairService;

import java.util.List;

@RestController
@RequestMapping("/repair-service/api")
public class RepairRestController {

    private final RepairService repairService;


    @Autowired
    public RepairRestController(RepairService repairService) {
        this.repairService = repairService;
    }

    @GetMapping("/findAllRepairs")
    public List<RepairDTO> findAllRepairs() {
        return repairService.findAllRepairs();
    }

    @GetMapping("/findRepairById/{id}")
    public RepairDTO getRepair(@PathVariable("id") Long id) {
        return repairService.findRepairById(id);
    }

}
