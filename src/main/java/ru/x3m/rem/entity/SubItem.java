package ru.x3m.rem.entity;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "subitems", schema = "rem_db")
public class SubItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subitemId;

    @Valid
    @NotNull
    @Column(name = "subitem_name")
    private String subitemName;

    @ManyToOne
    @JoinColumn(name = "items_item_id", insertable = false, updatable = false)
    private Item item;

    @Column(name = "items_item_id")
    private Long itemsItemId;

    @OneToMany(
            mappedBy = "subItem",
            cascade = CascadeType.ALL
    )
    private List<Outlay> outlays;

    public SubItem() {
    }

    public Long getSubitemId() {
        return subitemId;
    }

    public void setSubitemId(Long subitemId) {
        this.subitemId = subitemId;
    }

    public String getSubitemName() {
        return subitemName;
    }

    public void setSubitemName(String subitemName) {
        this.subitemName = subitemName;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Long getItemsItemId() {
        return itemsItemId;
    }

    public void setItemsItemId(Long itemsItemId) {
        this.itemsItemId = itemsItemId;
    }

}
