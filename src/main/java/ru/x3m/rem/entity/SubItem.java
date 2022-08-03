package ru.x3m.rem.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
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

}
