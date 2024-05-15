package org.grapheople.inmaroom.club.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateClubRequest {
    private String iconUrl;
    private String name;
    private String description;
    private List<String> tagList;
}
