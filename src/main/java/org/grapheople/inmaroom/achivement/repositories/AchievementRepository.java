package org.grapheople.inmaroom.achivement.repositories;

import org.grapheople.inmaroom.achivement.entities.Achievement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AchievementRepository extends JpaRepository<Achievement, Long> {
}
