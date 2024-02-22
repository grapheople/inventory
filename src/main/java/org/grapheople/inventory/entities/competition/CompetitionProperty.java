package org.grapheople.inventory.entities.competition;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.grapheople.inventory.enums.PropertyType;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "competition_property")
public class CompetitionProperty {
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long itemId;
    @Enumerated(EnumType.STRING)
    private PropertyType propertyType;
    private String name;
    private String content;

}
