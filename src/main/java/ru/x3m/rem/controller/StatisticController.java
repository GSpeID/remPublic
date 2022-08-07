package ru.x3m.rem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.x3m.rem.dto.ItemDTO;
import ru.x3m.rem.dto.OutlayDTO;
import ru.x3m.rem.dto.SubItemDTO;
import ru.x3m.rem.entity.Item;
import ru.x3m.rem.entity.Outlay;
import ru.x3m.rem.entity.SubItem;
import ru.x3m.rem.repository.OutlayRepo;
import ru.x3m.rem.service.StatisticService;

import javax.validation.*;
import java.util.List;

@Controller
public class StatisticController {

    private final StatisticService statisticService;
    private final OutlayRepo outlayRepo;

    @Autowired
    public StatisticController(StatisticService statisticService, OutlayRepo outlayRepo) {
        this.statisticService = statisticService;
        this.outlayRepo = outlayRepo;
    }

    private void models(Model model) {
        List<OutlayDTO> outlaysDTO = statisticService.findAllOutlay();
        model.addAttribute("outlays" , outlaysDTO);
        List<SubItem> subItems = statisticService.findAllSubItem();
        model.addAttribute("subItems", subItems);
        List<Item> items = statisticService.findAllItems();
        model.addAttribute("items", items);
    }

    private boolean resendModels(BindingResult result, Model model) {
        if (result.hasErrors()){
            models(model);
            return true;
        }
        return false;
    }

    @GetMapping("/stat")
    public String statPage(Model model){
        model.addAttribute("outlayDTO", new OutlayDTO());
        model.addAttribute("itemDTO", new ItemDTO());
        model.addAttribute("subItemDTO", new SubItemDTO());
        models(model);
        return "stat";
    }


    //----- Save\Delete Outlay

    @PostMapping(value = "/stat/saveOutlay")
    public String saveOutlay(@ModelAttribute("outlayDTO") @Valid OutlayDTO outlayDTO, BindingResult result,
                             Model model,
                             @ModelAttribute("subItemDTO") SubItemDTO subItemDTO,
                             @ModelAttribute("itemDTO") ItemDTO itemDTO){
        if (resendModels(result, model))
            return "stat";
        statisticService.saveOutlay(outlayDTO);
        return "redirect:/stat";
    }

    @GetMapping("/stat/deleteOutlay/{id}")
    public String deleteOutlay(@PathVariable Long id){
        statisticService.deleteOutlay(id);
        return "redirect:/stat";
    }

    //----- Save\Delete Item

    @PostMapping(value = "/stat/saveItem")
    public String saveItem(@ModelAttribute("itemDTO") @Valid ItemDTO itemDTO, BindingResult result,
                           Model model,
                           @ModelAttribute("subItemDTO") SubItemDTO subItemDTO,
                           @ModelAttribute("outlayDTO") OutlayDTO outlayDTO){
        if (resendModels(result, model)) return "stat";
        statisticService.saveItems(itemDTO);
        return "redirect:/stat";
    }

    @GetMapping("/stat/deleteItem/{id}")
    public String deleteItem(@PathVariable Long id){
        statisticService.deleteItem(id);
        return "redirect:/stat";
    }

    //----- Save\Delete SubItem

    @PostMapping("/stat/saveSubItem")
    public String saveSubItem(@ModelAttribute("subItemDTO") @Valid SubItemDTO subItemDTO, BindingResult result,
                              Model model,
                              @ModelAttribute("itemDTO") ItemDTO itemDTO,
                              @ModelAttribute("outlayDTO") OutlayDTO outlayDTO){
        if (resendModels(result, model)) return "stat";
        statisticService.saveSubItem(subItemDTO);
        return "redirect:/stat";
    }

    @GetMapping("/stat/deleteSubItem/{id}")
    public String deleteSubItem(@PathVariable Long id){
        statisticService.deleteSubItem(id);
        return "redirect:/stat";
    }


}
