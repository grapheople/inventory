package org.grapheople.inmaroom.club.controllers;

import lombok.RequiredArgsConstructor;
import org.grapheople.inmaroom.club.entities.Club;
import org.grapheople.inmaroom.club.servieces.ClubService;
import org.grapheople.inmaroom.club.vo.ClubVO;
import org.grapheople.inmaroom.club.vo.CreateClubRequest;
import org.grapheople.inmaroom.common.ApiResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/club")
@RequiredArgsConstructor
public class ClubAPIController {
    private final ClubService clubService;

    @PostMapping("")
    public ResponseEntity<ApiResult<Club>> createClub(@RequestBody CreateClubRequest request) {
        return ResponseEntity.ok(new ApiResult<>(clubService.createClub(request)));
    }
}
