package org.grapheople.inmaroom.club.vo;

import jakarta.persistence.Convert;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.grapheople.inmaroom.club.entities.Club;
import org.grapheople.inmaroom.converter.StringListConverter;

import java.util.List;

@AllArgsConstructor
@Data
public class ClubVO {
    private Long id;
    private String iconUrl;
    private String name;
    private String description;
    private List<String> tagList;

    public static ClubVO of(Club club) {
        return new ClubVO(
                club.getId(),
                club.getIconUrl(),
                club.getName(),
                club.getDescription(),
                club.getTagList()
        );
    }
}
