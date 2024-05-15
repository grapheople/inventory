package org.grapheople.inmaroom.club.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.grapheople.inmaroom.common.BaseEntity;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "club_article")
public class ClubArticle extends BaseEntity {
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private String imageUrl;
    private Long clubId;
    private Long userId;
    private String writerName;
}
