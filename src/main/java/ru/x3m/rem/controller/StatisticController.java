package ru.x3m.rem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.x3m.rem.entity.CostItem;
import ru.x3m.rem.entity.LlcOutlay;
import ru.x3m.rem.entity.SubCostItem;
import ru.x3m.rem.service.StatisticService;

import java.util.List;

@Controller
public class StatisticController {

    private StatisticService statisticService;

    @Autowired
    public StatisticController(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @GetMapping("/stat")
    public String allStatPage(Model model){
        List<LlcOutlay> llcOutlays = statisticService.findAllLlcOutlays();
        model.addAttribute("llcOutlaysCL", llcOutlays);
        List<CostItem> costItems = statisticService.findAllCostItem();
        model.addAttribute("costItemsCL", costItems);
        List<SubCostItem> subCostItems = statisticService.findAllSubCostItem();
        model.addAttribute("subCostItemsCL", subCostItems);
        return "/stat";
    }

}
