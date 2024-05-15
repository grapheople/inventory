package org.grapheople.inmaroom.item.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ItemPropertyType {
    SIZE("사이즈"),
    WEIGHT("무게"),
    WIDTH("가로길이"),
    HEIGHT("세로길이"),
    DEPTH("깊이"),
    COLOR("색상"),
    MATERIAL("재질"),
    MODEL_YEAR("모델연식"),
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
