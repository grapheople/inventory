package org.grapheople.inmaroom.competition.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum CompetitionCategory {
    CYCLE("자전거"),
    RUN("러닝"),
    ETC("기타")
    ;

    private final String description;

}
