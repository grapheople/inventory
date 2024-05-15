package org.grapheople.inmaroom.item.repositories;

import org.grapheople.inmaroom.item.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
