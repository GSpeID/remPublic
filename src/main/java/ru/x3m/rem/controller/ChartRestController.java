package ru.x3m.rem.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.x3m.rem.dto.ChartDTO;
import ru.x3m.rem.dto.ItemDTO;
import ru.x3m.rem.entity.Chart;
import ru.x3m.rem.entity.Item;
import ru.x3m.rem.service.ChartService;
import ru.x3m.rem.service.StatisticService;

import java.util.List;
import java.util.stream.Collectors;

@Validated
@RestController
@RequestMapping("/charts/api")
public class ChartRestController {
    private final ModelMapper modelMapper;
    private final StatisticService statisticService;

    private final ChartService chartService;


    @Autowired
    public ChartRestController(StatisticService statisticService, ModelMapper modelMapper,
                               ChartService chartService) {
        this.statisticService = statisticService;
        this.modelMapper = modelMapper;
        this.chartService = chartService;
    }


    @GetMapping("/getItems")
    public List<ItemDTO> getItems() {
        return statisticService.findAllItems();
    }

    @PostMapping("/getCharts")
    @ResponseBody
    public List<ChartDTO> getCharts(@RequestBody ChartDTO.Response.Public request) {
        List<Chart> charts = chartService.findAllCharts();
        System.out.println(request.toString());
        return charts.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    //--- entity to DTO
    public ChartDTO convertToDto(Chart chart) {
        return modelMapper.map(chart, ChartDTO.class);
    }

    //--- DTO to entity
    public Chart convertToEntity(ChartDTO chartDTO) {
        return modelMapper.map(chartDTO, Chart.class);
    }

    //--- entity to DTO
    public ItemDTO convertToDto(Item item) {
        return modelMapper.map(item, ItemDTO.class);
    }

    //--- DTO to entity
    public Item convertToEntity(ItemDTO itemDTO) {
        return modelMapper.map(itemDTO, Item.class);
    }


}
