package org.grapheople.inmaroom.item.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.grapheople.inmaroom.item.enums.ItemPropertyType;

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
    private String content;

    public ItemProperty(ItemPropertyType itemPropertyType, String content) {
        this.itemPropertyType = itemPropertyType;
        this.content = content;
    }
}
