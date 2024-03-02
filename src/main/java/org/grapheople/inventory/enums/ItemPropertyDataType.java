package org.grapheople.inventory.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ItemPropertyDataType {
    LINK("링크"),
    PLAIN_TEXT("텍스트"),
    IMAGE("이미지"),
    VIDEO("비디오"),
    JSON("JSON")
    ;


    private final String description;
}
