package org.grapheople.inventory.vo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.grapheople.inventory.enums.PropertyType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCompetitionPropertyRequest {
    private PropertyType propertyType;
    private String name;
    private String content;
}
