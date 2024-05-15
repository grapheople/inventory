package org.grapheople.inmaroom.club.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.grapheople.inmaroom.converter.StringListConverter;
import org.grapheople.inmaroom.common.BaseEntity;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "club")
public class Club extends BaseEntity {
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String iconUrl;
    private String name;
    private String description;

    @Convert(converter = StringListConverter.class)
    private List<String> tagList;
}
