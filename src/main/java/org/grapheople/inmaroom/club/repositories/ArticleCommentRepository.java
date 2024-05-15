package org.grapheople.inmaroom.club.repositories;

import org.grapheople.inmaroom.club.entities.ArticleComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleCommentRepository extends JpaRepository<ArticleComment, Long> {
}
