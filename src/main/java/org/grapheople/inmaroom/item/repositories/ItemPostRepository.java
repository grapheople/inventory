package org.grapheople.inmaroom.item.repositories;

import org.grapheople.inmaroom.item.entities.ItemPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ItemPostRepository extends JpaRepository<ItemPost, Long> {
}
