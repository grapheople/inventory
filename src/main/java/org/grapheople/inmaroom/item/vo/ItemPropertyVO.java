package org.grapheople.inmaroom.item.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.grapheople.inmaroom.item.enums.ItemPropertyType;
import org.grapheople.inmaroom.item.entities.ItemProperty;

@AllArgsConstructor
@Data
public class ItemPropertyVO {
    private Long id;
    private Long itemId;
    private ItemPropertyType itemPropertyType;
    private String content;

    public static ItemPropertyVO of(ItemProperty itemProperty) {
        return new ItemPropertyVO(
                itemProperty.getId(),
                itemProperty.getItemId(),
                itemProperty.getItemPropertyType(),
                itemProperty.getContent()
        );
    }
}
