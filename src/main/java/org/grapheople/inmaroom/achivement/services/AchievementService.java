package org.grapheople.inmaroom.achivement.services;

import lombok.RequiredArgsConstructor;
import org.grapheople.inmaroom.achivement.repositories.AchievementRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AchievementService {
    private final AchievementRepository achievementRepository;
}
