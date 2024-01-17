package org.grapheople.inventory.vo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.grapheople.inventory.enums.ItemPropertyType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateItemPropertyRequest {
    private ItemPropertyType propertyType;
    private String name;
    private String content;
}
