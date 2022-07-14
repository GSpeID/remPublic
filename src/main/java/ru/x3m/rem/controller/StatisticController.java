package ru.x3m.rem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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

    private StatisticService statisticService;
    private OutlayRepo outlayRepo;

    @Autowired
    public StatisticController(StatisticService statisticService, OutlayRepo outlayRepo) {
        this.statisticService = statisticService;
        this.outlayRepo = outlayRepo;
    }

//    @GetMapping("/error")
//    public String errorPage(){
//        return "/error";
//    }

    @GetMapping("/stat")
    public String statPage(Model model){
        model.addAttribute("outlay", new Outlay());
        List<Outlay> outlays = (List<Outlay>) outlayRepo.findAll();
        model.addAttribute("outlays" , outlays);
        List<SubItem> subItems = statisticService.findAllSubItem();
        model.addAttribute("subItems", subItems);
        List<Item> items = statisticService.findAllItems();
        model.addAttribute("items", items);
        return "stat";
    }

    //----- Save\Delete Outlay

    @GetMapping("/stat/new")
    public String newOutlay(Model model){
        model.addAttribute("outlay", new Outlay());
        List<SubItem> subItems = statisticService.findAllSubItem();
        model.addAttribute("subItems", subItems);
        List<Item> items = statisticService.findAllItems();
        model.addAttribute("items", items);

        return "newoutlay";
    }

    @PostMapping("/stat/new")
    public String saveOutlay(@Valid @ModelAttribute Outlay outlay,
                             BindingResult bindingResult, Model model, RedirectAttributes atts){
        if (bindingResult.hasErrors()){
            atts.addAttribute("hasErrors", true);
            List<SubItem> subItems = statisticService.findAllSubItem();
            model.addAttribute("subItems", subItems);
            List<Item> items = statisticService.findAllItems();
            model.addAttribute("items", items);
            return "newoutlay";
        }
//        outlayRepo.save(outlay);
//        statisticService.saveOutlayDTO(outlayDTO);
        return "redirect:/stat";
    }


    @GetMapping("/stat/deleteOutlay/{id}")
    public String deleteOutlay(@PathVariable Long id){
        statisticService.deleteOutlay(id);
        return "redirect:/stat";
    }

    //----- Save\Delete Item
    @PostMapping(value = "/stat/saveItem")
    public String saveItem(@ModelAttribute("itemSaving") @Valid ItemDTO itemDTO,
                             BindingResult result){
        if (result.hasErrors()){
            return "redirect:/error";
        }
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
    public String saveOutlay(@ModelAttribute("subItem") @Valid SubItemDTO subItemDTO,
                             BindingResult result){
        if (result.hasErrors()){
            return "redirect:/error";
        }
        statisticService.saveSubItem(subItemDTO);
        return "redirect:/stat";
    }

    @GetMapping("/stat/deleteSubItem/{id}")
    public String deleteSubItem(@PathVariable Long id){
        statisticService.deleteSubItem(id);
        return "redirect:/stat";
    }


}
