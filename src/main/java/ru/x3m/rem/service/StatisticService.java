package ru.x3m.rem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.x3m.rem.dto.*;
import ru.x3m.rem.entity.*;
import ru.x3m.rem.repository.*;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StatisticService {

    private final OutlayRepo outlayRepo;
    private final ItemRepo itemRepo;
    private final SubItemRepo subItemRepo;

    @Autowired
    public StatisticService(OutlayRepo outlayRepo, ItemRepo itemRepo, SubItemRepo subItemRepo) {
        this.outlayRepo = outlayRepo;
        this.itemRepo = itemRepo;
        this.subItemRepo = subItemRepo;
    }

    //-- Outlay

    public Optional<OutlayDTO> findOutlayById(Long id){
        return outlayRepo.findById(id)
                .map(OutlayDTO::new);
    }

    public List<Outlay> findAllOutlay(){
        return (List<Outlay>) outlayRepo.findAll();
    }


    public void saveOutlay(OutlayDTO outlayDTO){
        Outlay outlay = new Outlay();
        outlay.setOutlayId(outlayDTO.getOutlayId());
        outlay.setDescription(outlayDTO.getDescription());
        outlay.setPrice(outlayDTO.getPrice());
        outlay.setDate(outlayDTO.getDate());
        outlay.setItemsItemId(outlayDTO.getItemsItemId());
        outlay.setSubitemsSubitemId(outlayDTO.getSubitemsSubitemId());
        outlayRepo.save(outlay);
    }

    public void deleteOutlay(Long id){
        outlayRepo.findById(id)
                .ifPresent(outlayRepo::delete);
    }

    //-- Item

    public Optional<ItemDTO> findItemById(Long id){
        return itemRepo.findById(id)
                .map(ItemDTO::new);
    }

    public List<Item> findAllItems(){
        return (List<Item>) itemRepo.findAll();
    }

    public void saveItems(ItemDTO itemDTO){
        Item item = new Item();
        item.setItemId(itemDTO.getItemId());
        item.setItemName(itemDTO.getItemName());
        itemRepo.save(item);
    }

    public void deleteItem(Long id){
        itemRepo.findById(id)
                .ifPresent(itemRepo::delete);
    }

    //-- SubItem

    public Optional<SubItemDTO> findSubItemById(Long id){
        return subItemRepo.findById(id)
                .map(SubItemDTO::new);
    }

    public List<SubItem> findAllSubItem(){
        return (List<SubItem>) subItemRepo.findAll();
    }


    public List<SubItem> findAllSubByItemsItemId(Long id){
        return subItemRepo.findAllByItemsItemId(id);
    }


    public void saveSubItem(SubItemDTO subItemDTO){
        SubItem subItem = new SubItem();
        subItem.setSubitemId(subItemDTO.getSubitemId());
        subItem.setSubitemName(subItemDTO.getSubitemName());
        subItem.setItemsItemId(subItemDTO.getItemsItemId());
        subItemRepo.save(subItem);
    }

    public void deleteSubItem(Long id){
        subItemRepo.findById(id)
                .ifPresent(subItemRepo::delete);
    }

}
