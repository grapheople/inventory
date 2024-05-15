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
@Table(name = "article_comment")
public class ArticleComment extends BaseEntity {
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long articleId;
    private Long parentId;
    private Long userId;
    private String toUserName;
    private String writerName;
    private String content;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "parentId")
    private List<ArticleComment> childCommentList;
}
