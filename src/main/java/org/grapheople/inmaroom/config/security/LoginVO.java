package org.grapheople.inmaroom.config.security;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginVO {
    @NotBlank
    private String email;
    @NotBlank
    private String password;
}
