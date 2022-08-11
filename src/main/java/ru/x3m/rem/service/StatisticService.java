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

    public OutlayDTO findOutlayById(Long id) {
        Outlay outlay = outlayRepo.findByOutlayId(id);
        return ObjectMapperUtils.map(outlay, OutlayDTO.class);
    }

    public List<OutlayDTO> findAllOutlaysByItemId(Long id) {
        List<Outlay> outlays = outlayRepo.findAllByItemsItemId(id);
        return ObjectMapperUtils.mapAll(outlays, OutlayDTO.class);
    }

    public List<OutlayDTO> findOutlayBySubItemId(Long id) {
        List<Outlay> outlays = outlayRepo.findAllBySubitemsSubitemId(id);
        return ObjectMapperUtils.mapAll(outlays, OutlayDTO.class);
    }


    public void saveOutlay(OutlayDTO outlayDTO) {
        Outlay outlay = ObjectMapperUtils.map(outlayDTO, Outlay.class);
        outlayRepo.save(outlay);
    }

    public void deleteOutlay(Long id) {
        outlayRepo.findById(id)
                .ifPresent(outlayRepo::delete);
    }

    //-- Item

    public boolean ifItemExist(String itemName) {
        return itemRepo.existsByItemName(itemName);
    }

    public ItemDTO findItemById(Long id) {
        Item item = itemRepo.findByItemId(id);
        return ObjectMapperUtils.map(item, ItemDTO.class);
    }

    public List<ItemDTO> findAllItems() {
        List<Item> items = (List<Item>) itemRepo.findAll();
        return ObjectMapperUtils.mapAll(items, ItemDTO.class);
    }

    public void saveItems(ItemDTO itemDTO) {
        Item item = ObjectMapperUtils.map(itemDTO, Item.class);
        itemRepo.save(item);
    }

    public void deleteItem(Long id) {
        itemRepo.findById(id)
                .ifPresent(itemRepo::delete);
    }

    //-- SubItem

    public boolean ifSubitemNameExist(String subitemName) {
        return subItemRepo.existsBySubitemName(subitemName);
    }

    public SubItemDTO findSubItemById(Long id) {
        SubItem subItem = subItemRepo.findBySubitemId(id);
        return ObjectMapperUtils.map(subItem, SubItemDTO.class);
    }

    public List<SubItemDTO> findAllSubItem() {
        List<SubItem> subItems = (List<SubItem>) subItemRepo.findAll();
        return ObjectMapperUtils.mapAll(subItems, SubItemDTO.class);
    }


    public List<SubItemDTO> findAllSubByItemsItemId(Long id) {
        List<SubItem> subItems = (List<SubItem>) subItemRepo.findAll();
        return ObjectMapperUtils.mapAll(subItems, SubItemDTO.class);
    }


    public void saveSubItem(SubItemDTO subItemDTO) {
        SubItem subItem = ObjectMapperUtils.map(subItemDTO, SubItem.class);
        subItemRepo.save(subItem);
    }

    public void deleteSubItem(Long id) {
        subItemRepo.findById(id)
                .ifPresent(subItemRepo::delete);
    }

}
