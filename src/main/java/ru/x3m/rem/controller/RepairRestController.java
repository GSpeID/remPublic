package ru.x3m.rem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.x3m.rem.dto.RepairDTO;
import ru.x3m.rem.service.RepairService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping("/repair-service/api")
public class RepairRestController {

    private RepairService repairService;

    @Autowired
    public RepairRestController(RepairService repairService) {
        this.repairService = repairService;
    }

    @RequestMapping(value = "/findRepair/{repair_id}", method = RequestMethod.GET)
    public Optional<RepairDTO> getRepairByIdRest (HttpServletRequest request,
                                                  @PathVariable ("repair_id") Long repair_id ){
        return repairService.findRepairById(repair_id);
    }

}
