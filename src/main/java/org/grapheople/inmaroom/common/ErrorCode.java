package org.grapheople.inmaroom.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    NOT_FOUND(HttpStatus.NOT_FOUND, 100001,"Not Found"),
    ;

    private final HttpStatusCode code;
    private final Integer serviceErrorCode;
    private final String message;
}
