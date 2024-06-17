package org.grapheople.inmaroom.auth.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.grapheople.inmaroom.common.ApiResult;
import org.grapheople.inmaroom.config.security.JwtFilter;
import org.grapheople.inmaroom.config.security.LoginVO;
import org.grapheople.inmaroom.config.security.TokenProvider;
import org.grapheople.inmaroom.config.security.TokenVO;
import org.grapheople.inmaroom.user.entities.User;
import org.grapheople.inmaroom.user.repositories.UserRepository;
import org.grapheople.inmaroom.user.vo.UserVO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    private final TokenProvider tokenProvider;
    private final UserRepository userRepository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    @PostMapping("/authenticate")
    public ResponseEntity<ApiResult<TokenVO>> authorize(@Valid @RequestBody LoginVO loginVO) throws Exception {
        User user = userRepository.findByEmail(loginVO.getEmail()).orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));
        String jwt = tokenProvider.createToken(UserVO.from(user));
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);
        return ResponseEntity.ok().headers(httpHeaders).body(new ApiResult<>(new TokenVO(jwt)));
    }
}
