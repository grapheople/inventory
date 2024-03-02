package org.grapheople.inventory.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.grapheople.inventory.entities.competition.Competition;
import org.grapheople.inventory.entities.competition.CompetitionProperty;
import org.grapheople.inventory.entities.competition.CompetitionTag;
import org.grapheople.inventory.repositories.CompetitionRepository;
import org.grapheople.inventory.vo.request.CreateCompetitionRequest;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CompetitionService {
    private final CompetitionRepository competitionRepository;

    public void createCompetition(CreateCompetitionRequest request) {
        Competition competition = new Competition();
        competition.setCompanyId(request.getCompanyId());
        competition.setName(request.getName());
        competition.setDescription(request.getDescription());
        competition.setPropertyList(request.getPropertyList().stream().map(property -> {
            CompetitionProperty competitionProperty = new CompetitionProperty();
            competitionProperty.setItemPropertyType(property.getItemPropertyType());
            competitionProperty.setName(property.getName());
            competitionProperty.setContent(property.getContent());
            return competitionProperty;
        }).toList());
        competition.setTagList(request.getTagList().stream().map(tag -> {
            CompetitionTag competitionTag = new CompetitionTag();
            competitionTag.setName(tag.getName());
            return competitionTag;
        }).toList());
        competitionRepository.save(competition);
    }
}
