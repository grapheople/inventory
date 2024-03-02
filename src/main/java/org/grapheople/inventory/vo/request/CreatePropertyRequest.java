package org.grapheople.inventory.vo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.grapheople.inventory.enums.ItemPropertyType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePropertyRequest {
    private ItemPropertyType itemPropertyType;
    private String name;
    private String content;
}
