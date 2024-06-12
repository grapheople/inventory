package org.grapheople.inmaroom.competition.repositories;

import org.grapheople.inmaroom.competition.entities.Competition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitionRepository extends JpaRepository<Competition, Long> {
}
