package org.grapheople.inmaroom.vo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.grapheople.inmaroom.enums.ItemPropertyType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCompetitionPropertyRequest {
    private ItemPropertyType itemPropertyType;
    private String name;
    private String content;
}
