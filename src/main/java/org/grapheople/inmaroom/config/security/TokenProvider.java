package org.grapheople.inmaroom.config.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.grapheople.inmaroom.user.vo.UserVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.time.ZonedDateTime;
import java.util.Date;

@Slf4j
@Component
public class TokenProvider {
    private int tokenExpireInDays;
    private Key key;

    public TokenProvider(@Value("${jwt.secret}") String secret, @Value("${jwt.token-expire-in-days}") int tokenExpireInDays) {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        this.key = Keys.hmacShaKeyFor(keyBytes);
        this.tokenExpireInDays = tokenExpireInDays;
    }

    public String createToken(UserVO user) throws Exception {
        Claims claims = Jwts.claims()
                .add("id", user.getId())
                .add("email", user.getEmail())
                .add("role", String.join(",", user.getAuthorities()))
                .build();
        ZonedDateTime now = ZonedDateTime.now().plusDays(tokenExpireInDays);
        Date date = Date.from(now.toInstant());

        return Jwts.builder()
                .claims(claims)
                .issuedAt(Date.from(ZonedDateTime.now().toInstant()))
                .expiration(date)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // 토큰의 유효성 검증을 수행
    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {

            log.info("잘못된 JWT 서명입니다.");
        } catch (ExpiredJwtException e) {

            log.info("만료된 JWT 토큰입니다.");
        } catch (UnsupportedJwtException e) {

            log.info("지원되지 않는 JWT 토큰입니다.");
        } catch (IllegalArgumentException e) {

            log.info("JWT 토큰이 잘못되었습니다.");
        }
        return false;
    }

    public Claims parseClaims(String accessToken) {
        try {
            return Jwts.parser().setSigningKey(key).build().parseClaimsJws(accessToken).getBody();
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        }
    }

    public Long getUserId(String token) {
        return Long.parseLong(parseClaims(token).get("id").toString());
    }
}