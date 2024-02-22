package org.grapheople.inventory.vo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCompetitionRequest {
    private Long companyId;
    private String name;
    private String description;
    private List<CreatePropertyRequest> propertyList;
    private List<CreateCompetitionTagRequest> tagList;
}
