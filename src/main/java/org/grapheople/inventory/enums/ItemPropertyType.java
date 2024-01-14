package org.grapheople.inventory.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ItemPropertyType {
    LINK("링크"),
    PLAIN_TEXT("텍스트");

    private final String description;
}
