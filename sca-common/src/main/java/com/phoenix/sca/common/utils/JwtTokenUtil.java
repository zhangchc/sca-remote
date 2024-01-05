package com.phoenix.sca.common.utils;

import com.phoenix.sca.common.config.CommonProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class JwtTokenUtil {

    public static final String CLAIM_KEY_USER_ID = "userId";
    public static final String CLAIM_KEY_USER_NAME = "userName";

    @Resource
    private CommonProperties commonProperties;

    /**
     * 从token中获取JWT中的负载
     *
     * @param token
     * @return
     */
    private Claims getClaimsFromToken(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(commonProperties.getJwt().getSecret())
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            claims = e.getClaims();
        } catch (Exception e) {
            log.error("token:" + token);
            log.error("JWT格式验证失败:{}", e.getMessage(), e);
        }
        return claims;
    }

    /**
     * 从token中获取相应的value
     *
     * @param token
     * @param key
     * @return
     */
    public Object getValueFromToken(String token, String key) {
        Object value;
        try {
            Claims claims = getClaimsFromToken(token);
            value = claims.get(key);
        } catch (Exception e) {
            value = null;
        }
        return value;
    }

    /**
     * 判断token是否已经失效
     *
     * @param token
     * @return
     */
    public Boolean isTokenExpired(String token) {
        Boolean result;
        try {
            Claims claims = getClaimsFromToken(token);
            Date expiredDate = claims.getExpiration();
            result = expiredDate.before(new Date());
        } catch (Exception e) {
            result = true;
        }
        return result;
    }

//    /**
//     * 根据用户信息生成token
//     *
//     * @param userId
//     * @param enterpriseId
//     * @param expiration   过期时间(秒)
//     * @return
//     */
//    public String generateToken(String userId, String enterpriseId, Long expiration, String accountType, String userName) {
//        Map<String, Object> claims = new HashMap<>();
//        claims.put(CLAIM_KEY_USER_ID, userId);
//        claims.put(CLAIM_KEY_ENTERPRISE_ID, enterpriseId);
//        claims.put(CLAIM_KEY_ACCOUNT_TYPE, accountType);
//        claims.put(CLAIM_KEY_USER_NAME, userName);
//        return generateToken(claims, expiration);
//    }


    public String generateToken(Long userId, Long expiration, String userName) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USER_ID, userId);
        claims.put(CLAIM_KEY_USER_NAME, userName);
        return generateToken(claims, expiration);
    }

    /**
     * 根据负责生成JWT的token
     *
     * @param claims
     * @param expiration
     * @return
     */
    private String generateToken(Map<String, Object> claims, Long expiration) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000l))
                .signWith(SignatureAlgorithm.HS512, commonProperties.getJwt().getSecret())
                .compact();
    }
}
