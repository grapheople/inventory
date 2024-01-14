package org.grapheople.inventory.repositories;

import org.grapheople.inventory.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
