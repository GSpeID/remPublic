package ru.x3m.rem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.x3m.rem.dto.CostItemDTO;
import ru.x3m.rem.dto.LlcOutlayDTO;
import ru.x3m.rem.dto.SubCostItemDTO;
import ru.x3m.rem.entity.CostItem;
import ru.x3m.rem.entity.LlcOutlay;
import ru.x3m.rem.entity.SubCostItem;
import ru.x3m.rem.repository.*;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StatisticService {

    private LlcOutlayRepo llcOutlayRepo;
    private CostItemRepo costItemRepo;
    private SubCostItemRepo subCostItemRepo;

    @Autowired
    public StatisticService(LlcOutlayRepo llcOutlayRepo,
                            CostItemRepo costItemRepo,
                            SubCostItemRepo subCostItemRepo) {
        this.llcOutlayRepo = llcOutlayRepo;
        this.costItemRepo = costItemRepo;
        this.subCostItemRepo = subCostItemRepo;
    }

    public Optional<LlcOutlayDTO> findLlcOutlayById(Long id){
        return llcOutlayRepo.findById(id)
                .map(LlcOutlayDTO::new);
    }

    public List<LlcOutlay> findAllLlcOutlays(){
        return (List<LlcOutlay>) llcOutlayRepo.findAll();
    }

    public void saveLlcOutlay(LlcOutlayDTO llcOutlayDTO){
        LlcOutlay llcOutlay = new LlcOutlay();
        llcOutlay.setLlcOutlayId(llcOutlayDTO.getLlcOutlayId());
        llcOutlay.setDescription(llcOutlayDTO.getDescription());
        llcOutlay.setCost(llcOutlayDTO.getCost());
        llcOutlay.setDate(llcOutlayDTO.getDate());
        llcOutlay.setCostItemId(llcOutlayDTO.getCostItemId());
        llcOutlayRepo.save(llcOutlay);
    }

    public void deleteLlcOutlay(Long id){
        llcOutlayRepo.findById(id)
                .ifPresent(llcOutlay -> llcOutlayRepo.delete(llcOutlay));
    }

    public Optional<CostItemDTO> findCostItemById(Long id){
        return costItemRepo.findById(id)
                .map(CostItemDTO::new);
    }

    public List<CostItem> findAllCostItem(){
        return (List<CostItem>) costItemRepo.findAll();
    }

    public void saveCostItem(CostItemDTO costItemDTO){
        CostItem costItem = new CostItem();
        costItem.setCostItemId(costItemDTO.getCostItemId());
        costItem.setCostItemName(costItemDTO.getCostItemName());
        costItem.setSubCostItemId(costItemDTO.getSubCostItemId());
        costItemRepo.save(costItem);
    }

    public void deleteCostItem(Long id){
        costItemRepo.findById(id)
                .ifPresent(costItem -> costItemRepo.delete(costItem));
    }

    public Optional<SubCostItemDTO> findSubCostItemById(Long id){
        return subCostItemRepo.findById(id)
                .map(SubCostItemDTO::new);
    }

    public List<SubCostItem> findAllSubCostItem(){
        return (List<SubCostItem>) subCostItemRepo.findAll();
    }

    public void saveSubCostItem(SubCostItemDTO subCostItemDTO){
        SubCostItem subCostItem = new SubCostItem();
        subCostItem.setSubCostItemId(subCostItemDTO.getSubCostItemId());
        subCostItem.setSubCostItemName(subCostItemDTO.getSubCostItemName());
    }

    public void deleteSubCostItem(Long id){
        subCostItemRepo.findById(id)
                .ifPresent(subCostItem -> subCostItemRepo.delete(subCostItem));
    }

}
