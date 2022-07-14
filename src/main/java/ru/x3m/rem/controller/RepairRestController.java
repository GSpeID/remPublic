package ru.x3m.rem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.x3m.rem.dto.RepairDTO;
import ru.x3m.rem.entity.Repair;
import ru.x3m.rem.service.RepairService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/repair-service/api")
public class RepairRestController {

    private RepairService repairService;

    @Autowired
    public RepairRestController(RepairService repairService) {
        this.repairService = repairService;
    }

    @RequestMapping(value = "/findRepair/{repairId}", method = RequestMethod.GET)
    public Optional<RepairDTO> getRepairByIdRest (HttpServletRequest request,
                                                  @PathVariable ("repairId") Long repairId ){
        return repairService.findRepairById(repairId);
    }

    @RequestMapping("/rep")
    public List<Repair> getRep(){
        return repairService.findAllRepairs();
    }

}
