package org.grapheople.inmaroom.competition.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.grapheople.inmaroom.common.ApiResult;
import org.grapheople.inmaroom.competition.entities.Competition;
import org.grapheople.inmaroom.competition.services.CompetitionService;
import org.grapheople.inmaroom.competition.vo.CompetitionVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/competition")
public class CompetitionController {
    private final CompetitionService competitionService;

    @GetMapping("")
    public ResponseEntity<ApiResult<List<CompetitionVO>>> getCompetitions() {
        return ResponseEntity.ok(new ApiResult<>(competitionService.getCompetitions()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResult<CompetitionVO>> getCompetition(@PathVariable Long id) {
        return ResponseEntity.ok(new ApiResult<>(competitionService.getCompetition(id)));
    }

    @PostMapping("")
    public ResponseEntity<ApiResult<Competition>> createCompetition(@Valid @RequestBody CompetitionVO request) {
        return ResponseEntity.ok(new ApiResult<>(competitionService.createCompetition(request)));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResult<Competition>> updateCompetition(@PathVariable Long id, @RequestBody CompetitionVO request) {
        return ResponseEntity.ok(new ApiResult<>(competitionService.updateCompetition(id, request)));
    }
}
