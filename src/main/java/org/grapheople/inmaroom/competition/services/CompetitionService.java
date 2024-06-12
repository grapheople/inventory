package org.grapheople.inmaroom.competition.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.grapheople.inmaroom.common.CommonException;
import org.grapheople.inmaroom.common.ErrorCode;
import org.grapheople.inmaroom.competition.entities.Competition;
import org.grapheople.inmaroom.competition.repositories.CompetitionRepository;
import org.grapheople.inmaroom.competition.vo.CompetitionVO;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CompetitionService {
    private final CompetitionRepository competitionRepository;

    @Transactional
    public Competition createCompetition(CompetitionVO request) {
        return competitionRepository.save(Competition.from(request));
    }

    @Transactional
    public Competition updateCompetition(Long id, CompetitionVO request) {
        Competition competition = competitionRepository.findById(id).orElseThrow(() -> new CommonException(ErrorCode.NOT_FOUND));
        competition.setName(request.getName());
        competition.setDescription(request.getDescription());
        competition.setLocation(request.getLocation());
        competition.setHost(request.getHost());
        competition.setHostCompany(request.getHostCompany());
        competition.setSupport(request.getSupport());
        competition.setOutline(request.getOutline());
        competition.setGuide(request.getGuide());
        competition.setRule(request.getRule());
        competition.setNotice(request.getNotice());
        competition.setSouvenirsAndAwards(request.getSouvenirsAndAwards());
        return competitionRepository.save(competition);
    }

    public CompetitionVO getCompetition(Long id) {
        return CompetitionVO.from(competitionRepository.findById(id).orElseThrow(()-> new CommonException(ErrorCode.NOT_FOUND)));
    }

    public List<CompetitionVO> getCompetitions() {
        return competitionRepository.findAll().stream().map(CompetitionVO::from).toList();
    }
}
