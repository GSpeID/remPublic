package ru.x3m.rem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.x3m.rem.dto.ItemDTO;
import ru.x3m.rem.dto.OutlayDTO;
import ru.x3m.rem.dto.SubItemDTO;
import ru.x3m.rem.entity.Item;
import ru.x3m.rem.entity.Outlay;
import ru.x3m.rem.entity.SubItem;
import ru.x3m.rem.service.StatisticService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Validated
@RestController
@RequestMapping("/statistic/api/")
public class StatisticRestController {

    private StatisticService statisticService;

    @Autowired
    public StatisticRestController(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @RequestMapping(value = "/findOutlay/{id}", method = RequestMethod.GET)
    public Optional<OutlayDTO> getOutlayByIdRest(HttpServletRequest request,
                                                    @PathVariable("id") Long id){
        return statisticService.findOutlayById(id);
    }

    @RequestMapping(value = "/findItem/{id}", method = RequestMethod.GET)
    public Optional<ItemDTO> getItemByIdRest(HttpServletRequest request,
                                                    @PathVariable("id") Long id){
        return statisticService.findItemById(id);
    }

    @RequestMapping(value = "/findSubItem/{id}", method = RequestMethod.GET)
    public Optional<SubItemDTO> getSubItemByIdRest(HttpServletRequest request,
                                                @PathVariable("id") Long id){
        return statisticService.findSubItemById(id);
    }

    @RequestMapping(value = "/outlays", method = RequestMethod.GET)
    public List<Outlay> getOutlays(){
        return statisticService.findAllOutlay();
    }

    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public List<Item> getItems(){
        return statisticService.findAllItems();
    }

    @RequestMapping(value = "/subItems", method = RequestMethod.GET)
    public List<SubItem> getSub(){
        return statisticService.findAllSubItem();
    }

    @RequestMapping(value = "/subItemsByItemsId", method = RequestMethod.GET)
    public List<SubItem> getSubByItemsItemsId(@RequestParam("itemsItemId") Long itemsItemId){
        return statisticService.findAllSubByItemsItemId(itemsItemId);
    }

}
