package ru.x3m.rem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.x3m.rem.dto.ItemDTO;
import ru.x3m.rem.dto.OutlayDTO;
import ru.x3m.rem.dto.SubItemDTO;
import ru.x3m.rem.service.StatisticService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;


@Validated
@RestController
@RequestMapping("/statistic/api/")
public class StatisticRestController {

    private final StatisticService statisticService;

    @Autowired
    public StatisticRestController(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @PostMapping("/saveOutlay")
//    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public OutlayDTO saveOutlay(@RequestBody @Valid OutlayDTO outlayDTO,
                                BindingResult result){
        statisticService.saveOutlay(outlayDTO);
        return outlayDTO;
    }

    @GetMapping("/finAllOutlays")
    @ResponseBody
    public List<OutlayDTO> getAllOutlays() {
        return statisticService.findAllOutlay();
    }

    @GetMapping("/findOutlayByItem")
    @ResponseBody
    public List<OutlayDTO> getAllOutlaysByItem(@RequestParam("itemId") Long itemId) {
        return statisticService.findAllOutlaysByItemId(itemId);
    }

    @GetMapping("/findOutlayBySubitem")
    @ResponseBody
    public List<OutlayDTO> getAllOutlaysBySubitem(@RequestParam("subitemId") Long subitemId) {
        return statisticService.findOutlayBySubItemId(subitemId);
    }

    @GetMapping("/findOutlayById")
    @ResponseBody
    public OutlayDTO getOutlayById(@RequestParam("id") Long id){
        return statisticService.findOutlayById(id);
    }

    @GetMapping(value = "/findItem/{id}")
    public ItemDTO getItemById(@PathVariable("id") Long id) {
        return statisticService.findItemById(id);
    }

    @GetMapping(value = "/findSubItem/{id}")
    public SubItemDTO getSubItemByIdRest(HttpServletRequest request,
                                                   @PathVariable("id") Long id) {
        return statisticService.findSubItemById(id);
    }


    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public List<ItemDTO> getItems(){
        return statisticService.findAllItems();
    }

    @RequestMapping(value = "/subItems", method = RequestMethod.GET)
    public List<SubItemDTO> getSub() {
        return statisticService.findAllSubItem();
    }

    @GetMapping(value = "/subItemsByItem")
    @ResponseBody
    public List<SubItemDTO> getSubByItemsByItem(@RequestParam("itemsItemId") Long itemsItemId) {
        return statisticService.findAllSubByItemsItemId(itemsItemId);
    }

}
