package org.grapheople.inmaroom.item.entities;

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
@Table(name = "item")
public class Item extends BaseEntity {
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Convert(converter = StringListConverter.class)
    private List<String> imageList;

    private String name;
    private String description;
    private Long userId;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "itemId")
    private List<ItemProperty> propertyList;

    @Convert(converter = StringListConverter.class)
    private List<String> tagList;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "parentId")
    private List<Item> componentList;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "itemId")
    private List<ItemPost> postList;

    private Long parentId;
}
