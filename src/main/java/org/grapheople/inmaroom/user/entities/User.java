package org.grapheople.inmaroom.user.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.grapheople.inmaroom.common.BaseEntity;
import org.grapheople.inmaroom.user.vo.UserVO;

import java.time.LocalDate;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User extends BaseEntity {
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userName;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;

    private String isMale;
    private String phoneNumber;
    private String address1;
    private String address2;
    private LocalDate birthDate;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_authority",
            joinColumns = {@JoinColumn(name = "id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "name", referencedColumnName = "name")})
    private Set<Authority> authorities;

    public static User from(UserVO userVO) {
        return new User(null,
                userVO.getUserName(),
                userVO.getEmail(),
                userVO.getPassword(),
                userVO.getIsMale(),
                userVO.getPhoneNumber(),
                userVO.getAddress1(),
                userVO.getAddress2(),
                userVO.getBirthDate(),
                null);
    }
}
