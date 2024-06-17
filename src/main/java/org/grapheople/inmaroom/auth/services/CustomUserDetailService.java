package org.grapheople.inmaroom.auth.services;

import lombok.RequiredArgsConstructor;
import org.grapheople.inmaroom.auth.vo.CustomUserDetails;
import org.grapheople.inmaroom.user.entities.User;
import org.grapheople.inmaroom.user.repositories.UserRepository;
import org.grapheople.inmaroom.user.vo.UserVO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String id) {
        User user = userRepository.findById(Long.parseLong(id)).orElseThrow(() -> new IllegalArgumentException("User not found"));

        UserVO userVO = UserVO.from(user);
        return new CustomUserDetails(userVO);
    }
}
