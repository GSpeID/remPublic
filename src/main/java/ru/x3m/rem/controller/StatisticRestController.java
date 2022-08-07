package ru.x3m.rem.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.x3m.rem.dto.ItemDTO;
import ru.x3m.rem.dto.OutlayDTO;
import ru.x3m.rem.dto.SubItemDTO;
import ru.x3m.rem.entity.Item;
import ru.x3m.rem.entity.Outlay;
import ru.x3m.rem.entity.SubItem;
import ru.x3m.rem.service.StatisticService;
import ru.x3m.rem.utils.ObjectMapperUtils;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
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

    @PostMapping("/saveOutlay")
//    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public OutlayDTO saveOutlay(@RequestBody @Valid OutlayDTO outlayDTO,
                                BindingResult result){
        Outlay outlay = ObjectMapperUtils.map(outlayDTO, Outlay.class);
        statisticService.saveOutlayRest(outlay);
        return outlayDTO;
    }

    @GetMapping("/finAllOutlays")
    @ResponseBody
    public List<OutlayDTO> getAllOutlays() {
        List<Outlay> outlays = statisticService.findAllOutlayRest();
        return ObjectMapperUtils.mapAll(outlays, OutlayDTO.class);
    }

    @GetMapping("/findOutlayByItem")
    @ResponseBody
    public List<OutlayDTO> getAllOutlaysByItem(@RequestParam("itemId") Long itemId) {
        List<Outlay> outlays = statisticService.findOutlaysByItemIdRest(itemId);
        return ObjectMapperUtils.mapAll(outlays, OutlayDTO.class);
    }

    @GetMapping("/findOutlayBySubitem")
    @ResponseBody
    public List<OutlayDTO> getAllOutlaysBySubitem(@RequestParam("subitemId") Long subitemId) {
        List<Outlay> outlays = statisticService.findOutlayBySubItemIdRest(subitemId);
        return ObjectMapperUtils.mapAll(outlays, OutlayDTO.class);
    }

    @GetMapping("/findOutlayById")
    @ResponseBody
    public OutlayDTO getOutlayById(@RequestParam("id") Long id){
        Outlay outlay = statisticService.findOutlayByIdRest(id);
        return ObjectMapperUtils.map(outlay, OutlayDTO.class);
    }

    @GetMapping(value = "/findItem/{id}")
    public ItemDTO getItemById(@PathVariable("id") Long id) {
        Item item = statisticService.findItemById(id);
        return ObjectMapperUtils.map(item, ItemDTO.class);
    }

    @GetMapping(value = "/findSubItem/{id}")
    public SubItemDTO getSubItemByIdRest(HttpServletRequest request,
                                                   @PathVariable("id") Long id) {
        SubItem subItem = statisticService.findSubItemById(id);
        return ObjectMapperUtils.map(subItem, SubItemDTO.class);
    }


    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public List<ItemDTO> getItems(){
        List<Item> items = statisticService.findAllItems();
        return ObjectMapperUtils.mapAll(items, ItemDTO.class);
    }

    @RequestMapping(value = "/subItems", method = RequestMethod.GET)
    public List<SubItemDTO> getSub() {
        List<SubItem> subItems = statisticService.findAllSubItem();
        return ObjectMapperUtils.mapAll(subItems, SubItemDTO.class);
    }

    @GetMapping(value = "/subItemsByItemsId")
    public List<SubItemDTO>  getSubByItemsItemsId(@RequestParam("itemsItemId") Long itemsItemId) {
        List<SubItem> subItems = statisticService.findAllSubByItemsItemId(itemsItemId);
        return ObjectMapperUtils.mapAll(subItems, SubItemDTO.class);
    }

    @GetMapping(value = "/subItemsByItem")
    @ResponseBody
    public List<SubItemDTO> getSubByItemsByItem(@RequestParam("itemsItemId") Long itemsItemId) {
        List<SubItem> subItems = statisticService.findAllSubByItemsItemId(itemsItemId);
        return ObjectMapperUtils.mapAll(subItems, SubItemDTO.class);
    }

}
