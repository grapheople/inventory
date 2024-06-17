package org.grapheople.inmaroom.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.grapheople.inmaroom.common.ApiResult;
import org.grapheople.inmaroom.user.services.UserService;
import org.grapheople.inmaroom.user.vo.UserVO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<ApiResult<UserVO>> signup(@Valid @RequestBody UserVO userVO) {
        return ResponseEntity.ok(new ApiResult<>(userService.createUser(userVO)));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/me")
    public ResponseEntity<ApiResult<UserVO>> me(@AuthenticationPrincipal Long userId) {
        return ResponseEntity.ok(new ApiResult<>(userService.getMe(userId)));
    }
}
