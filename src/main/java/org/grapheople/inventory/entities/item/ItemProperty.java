package org.grapheople.inventory.entities.item;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.grapheople.inventory.enums.ItemPropertyDataType;
import org.grapheople.inventory.enums.ItemPropertyType;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "item_property")
public class ItemProperty {
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long itemId;
    @Enumerated(EnumType.STRING)
    private ItemPropertyType itemPropertyType;
    @Enumerated(EnumType.STRING)
    private ItemPropertyDataType propertyDataType;
    private String name;
    private String content;

    public ItemProperty(ItemPropertyType itemPropertyType, ItemPropertyDataType itemPropertyDataType, String name, String content) {
        this.itemPropertyType = itemPropertyType;
        this.propertyDataType = itemPropertyDataType;
        this.name = name;
        this.content = content;
    }
}
