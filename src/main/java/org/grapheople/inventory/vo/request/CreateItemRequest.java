package org.grapheople.inventory.vo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateItemRequest {
    private String name;
    private String description;
    private List<String> imageList;
    private List<CreatePropertyRequest> propertyList;
    private List<CreateItemTagRequest> tagList;
    private Long parentId;
    private List<Long> componentList;
}
