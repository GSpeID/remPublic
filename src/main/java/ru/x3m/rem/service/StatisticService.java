package ru.x3m.rem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.x3m.rem.dto.ItemDTO;
import ru.x3m.rem.dto.OutlayDTO;
import ru.x3m.rem.dto.SubItemDTO;
import ru.x3m.rem.entity.Item;
import ru.x3m.rem.entity.Outlay;
import ru.x3m.rem.entity.SubItem;
import ru.x3m.rem.repository.ItemRepo;
import ru.x3m.rem.repository.OutlayRepo;
import ru.x3m.rem.repository.SubItemRepo;
import ru.x3m.rem.utils.ObjectMapperUtils;

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

    public List<OutlayDTO> findAllOutlay() {
        List<Outlay> outlays = (List<Outlay>) outlayRepo.findAll();
        return ObjectMapperUtils.mapAll(outlays, OutlayDTO.class);
    }

    public void saveOutlay(OutlayDTO outlayDTO) {
        Outlay outlay = new Outlay();
        outlay.setOutlayId(outlayDTO.getOutlayId());
        outlay.setDescription(outlayDTO.getDescription());
        outlay.setPrice(outlayDTO.getPrice());
        outlay.setDate(outlayDTO.getDate());
        outlay.setItemsItemId(outlayDTO.getItemsItemId());
        outlay.setSubitemsSubitemId(outlayDTO.getSubitemsSubitemId());
        outlayRepo.save(outlay);
    }

    public void saveOutlayRest(Outlay outlay) {
        outlay.setOutlayId(outlay.getOutlayId());
        outlay.setDescription(outlay.getDescription());
        outlay.setPrice(outlay.getPrice());
        outlay.setDate(outlay.getDate());
        outlay.setItemsItemId(outlay.getItemsItemId());
        outlay.setSubitemsSubitemId(outlay.getSubitemsSubitemId());
        outlayRepo.save(outlay);
    }

    public void deleteOutlay(Long id) {
        outlayRepo.findById(id)
                .ifPresent(outlayRepo::delete);
    }

    //Outlay Rest
    public List<Outlay> findAllOutlayRest() {
        return (List<Outlay>) outlayRepo.findAll();
    }

    public List<Outlay> findOutlaysByItemIdRest(Long id) {
        return outlayRepo.findAllByItemsItemId(id);
    }

    public List<Outlay> findOutlayBySubItemIdRest(Long id) {
        return outlayRepo.findAllBySubitemsSubitemId(id);
    }

    public Outlay findOutlayByIdRest(Long id) {
        return outlayRepo.findByOutlayId(id);
    }

    //-- Item

    public Item findItemById(Long id) {
        return itemRepo.findByItemId(id);
    }

    public List<Item> findAllItems() {
        return (List<Item>) itemRepo.findAll();
    }

    public void saveItems(ItemDTO itemDTO) {
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

    public SubItem findSubItemById(Long id){
        return subItemRepo.findBySubitemId(id);
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
