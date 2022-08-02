package ru.x3m.rem.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.x3m.rem.dto.ItemDTO;
import ru.x3m.rem.dto.OutlayDTO;
import ru.x3m.rem.dto.SubItemDTO;
import ru.x3m.rem.entity.Item;
import ru.x3m.rem.entity.Outlay;
import ru.x3m.rem.entity.SubItem;
import ru.x3m.rem.service.StatisticService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Validated
@RestController
@RequestMapping("/statistic/api/")
public class StatisticRestController {

    private final StatisticService statisticService;
    private final ModelMapper modelMapper;

    @Autowired
    public StatisticRestController(StatisticService statisticService,
                                   ModelMapper modelMapper) {
        this.statisticService = statisticService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/finAllOutlays")
    @ResponseBody
    public List<OutlayDTO> getAllOutlays() {
        List<Outlay> outlays = statisticService.findAllOutlayRest();
        return outlays.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/findOutlayByItem")
    @ResponseBody
    public List<OutlayDTO> getAllOutlaysByItem(@RequestParam("itemId") Long itemId) {
        List<Outlay> outlays = statisticService.findOutlaysByItemIdRest(itemId);
        return outlays.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/findOutlayBySubitem")
    @ResponseBody
    public List<OutlayDTO> getAllOutlaysBySubitem(@RequestParam("subitemId") Long subitemId) {
        List<Outlay> outlays = statisticService.findOutlayBySubItemIdRest(subitemId);
        return outlays.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/findItem/{id}", method = RequestMethod.GET)
    public Optional<ItemDTO> getItemByIdRest(HttpServletRequest request,
                                             @PathVariable("id") Long id) {
        return statisticService.findItemById(id);
    }

    @RequestMapping(value = "/findSubItem/{id}", method = RequestMethod.GET)
    public Optional<SubItemDTO> getSubItemByIdRest(HttpServletRequest request,
                                                @PathVariable("id") Long id){
        return statisticService.findSubItemById(id);
    }


    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public List<Item> getItems(){
        return statisticService.findAllItems();
    }

    @RequestMapping(value = "/subItems", method = RequestMethod.GET)
    public List<SubItem> getSub() {
        return statisticService.findAllSubItem();
    }

    @RequestMapping(value = "/subItemsByItemsId", method = RequestMethod.GET)
    public List<SubItem> getSubByItemsItemsId(@RequestParam("itemsItemId") Long itemsItemId) {
        return statisticService.findAllSubByItemsItemId(itemsItemId);
    }

    //--- entity to DTO
    private OutlayDTO convertToDto(Outlay outlay) {
        return modelMapper.map(outlay, OutlayDTO.class);
    }

    //--- DTO to entity
    private Outlay convertToEntity(OutlayDTO outlayDTO) {
        return modelMapper.map(outlayDTO, Outlay.class);
    }

}
