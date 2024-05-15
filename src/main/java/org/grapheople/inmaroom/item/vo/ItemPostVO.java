package org.grapheople.inmaroom.item.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.grapheople.inmaroom.item.entities.ItemPost;

import java.util.List;

@AllArgsConstructor
@Data
public class ItemPostVO {
    private Long id;
    private List<String> imageList;
    private Long userId;
    private Long itemId;
    private String content;

    public static ItemPostVO of(ItemPost itemPost) {
        return new ItemPostVO(
                itemPost.getId(),
                itemPost.getImageList(),
                itemPost.getUserId(),
                itemPost.getItemId(),
                itemPost.getContent()
        );
    }
}
