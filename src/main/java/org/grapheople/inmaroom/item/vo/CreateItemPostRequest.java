package org.grapheople.inmaroom.item.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateItemPostRequest {
    private String content;
    private List<String> imageList;
}
