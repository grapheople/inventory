package org.grapheople.inventory.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiResult<T> {
    @Builder.Default
    private Boolean success = true;

    private T result;

    private String errorCode;

    private String errorMessage;

    public ApiResult(T result) {
        this.result = result;
        this.success = true; // default
    }
}
