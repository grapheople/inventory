package org.grapheople.inventory.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ItemPropertyType {
    RECEIPT("영수증"),
    BUY_LINK("구매링크"),
    CUSTOM("사용자정의"),
    LOCATION("위치"),
    BUY_DATE("구매 날짜"),
    EXPIRATION_DATE("유통기한"),
    PRICE("가격"),
    ;


    private final String description;
}
