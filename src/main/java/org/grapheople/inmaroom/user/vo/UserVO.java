package org.grapheople.inmaroom.user.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.grapheople.inmaroom.user.entities.Authority;
import org.grapheople.inmaroom.user.entities.User;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {
    private Long id;

    private String userName;
    private String email;
    private String password;

    private String isMale;
    private String phoneNumber;
    private String address1;
    private String address2;
    private LocalDate birthDate;

    private Set<String> authorities;

    public static UserVO from(User user) {
        return new UserVO(user.getId(),
                user.getUserName(),
                user.getEmail(),
                user.getPassword(),
                user.getIsMale(),
                user.getPhoneNumber(),
                user.getAddress1(),
                user.getAddress2(),
                user.getBirthDate(),
                user.getAuthorities().stream().map(Authority::getName).collect(Collectors.toSet())
        );
    }
}
