package ru.x3m.rem.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.x3m.rem.dto.RepairDTO;
import ru.x3m.rem.entity.Repair;
import ru.x3m.rem.service.RepairService;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/repair-service/api")
public class RepairRestController {

    private final RepairService repairService;

    private final ModelMapper modelMapper;

    @Autowired
    public RepairRestController(RepairService repairService,
                                ModelMapper modelMapper) {
        this.repairService = repairService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/findAllRepairs")
    public List<RepairDTO> findAllRepairs() {
        List<Repair> repairs = repairService.findAllRepairs();
        return repairs.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/findRepairById/{id}")
    public RepairDTO getRepair(@PathVariable("id") Long id) {
        return convertToDto(repairService.findRepairById(id));
    }


    private RepairDTO convertToDto(Repair repair) {
        return modelMapper.map(repair, RepairDTO.class);
    }

    //--- DTO to entity
    private Repair convertToEntity(RepairDTO repairDTO) throws ParseException {
        return modelMapper.map(repairDTO, Repair.class);
    }

}
