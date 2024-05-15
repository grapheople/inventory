package org.grapheople.inmaroom.club.servieces;

import lombok.RequiredArgsConstructor;
import org.grapheople.inmaroom.club.entities.Club;
import org.grapheople.inmaroom.club.repositories.ClubRepository;
import org.grapheople.inmaroom.club.vo.CreateClubRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClubService {
    private final ClubRepository clubRepository;

    public Club createClub(CreateClubRequest createClubRequest) {
        Club club = new Club();
        club.setIconUrl(createClubRequest.getIconUrl());
        club.setName(createClubRequest.getName());
        club.setDescription(createClubRequest.getDescription());
        club.setTagList(createClubRequest.getTagList());
        return clubRepository.save(club);
    }
}
