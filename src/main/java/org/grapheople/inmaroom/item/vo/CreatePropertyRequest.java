package org.grapheople.inmaroom.item.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.grapheople.inmaroom.item.enums.ItemPropertyType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePropertyRequest {
    private ItemPropertyType itemPropertyType;
    private String content;
}
