package org.grapheople.inventory.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
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

    @Enumerated(EnumType.STRING)
    private ItemPropertyType propertyType;
    private String name;
    private String content;

}
