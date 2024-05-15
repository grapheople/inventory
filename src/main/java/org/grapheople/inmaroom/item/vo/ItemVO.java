package org.grapheople.inmaroom.item.vo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.grapheople.inmaroom.converter.StringListConverter;
import org.grapheople.inmaroom.item.entities.Item;
import org.grapheople.inmaroom.item.entities.ItemPost;
import org.grapheople.inmaroom.item.entities.ItemProperty;

import java.util.List;

@AllArgsConstructor
@Data
public class ItemVO {
    private Long id;
    private List<String> imageList;
    private String name;
    private String description;
    private Long userId;
    private List<ItemPropertyVO> propertyList;
    private List<String> tagList;
    private List<ItemVO> componentList;
    private List<ItemPostVO> postList;

    public static ItemVO of(Item item) {
        return new ItemVO(
                item.getId(),
                item.getImageList(),
                item.getName(),
                item.getDescription(),
                item.getUserId(),
                item.getPropertyList().stream().map(ItemPropertyVO::of).toList(),
                item.getTagList(),
                item.getComponentList().stream().map(ItemVO::of).toList(),
                item.getPostList().stream().map(ItemPostVO::of).toList()
        );
    }
}
