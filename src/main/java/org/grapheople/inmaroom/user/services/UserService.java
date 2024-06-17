package org.grapheople.inmaroom.user.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.grapheople.inmaroom.user.entities.Authority;
import org.grapheople.inmaroom.user.entities.User;
import org.grapheople.inmaroom.user.repositories.UserRepository;
import org.grapheople.inmaroom.user.vo.UserVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    public UserVO createUser(UserVO userVO) {
        User user = User.from(userVO);
        Authority authority = new Authority("ROLE_USER");
        user.setAuthorities(Set.of(authority));

        return UserVO.from(userRepository.save(user));
    }

    @Transactional(readOnly = true)
    public UserVO getMe(Long userId) {
        return userRepository.findById(userId)
                .map(UserVO::from)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));
    }
}
