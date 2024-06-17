package org.grapheople.inmaroom.controllers.api;

import lombok.extern.slf4j.Slf4j;
import org.grapheople.inmaroom.common.ApiResult;
import org.grapheople.inmaroom.common.ErrorCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResult> handleException(Exception ex) {
        log.error("handleException", ex);

        return ResponseEntity.ok(new ApiResult<>(ErrorCode.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage()));
    }
}
