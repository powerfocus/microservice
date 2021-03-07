package org.py.microservice.mongodb.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import lombok.extern.java.Log;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cqpythagoras
 * @date 2021-03-07
 */
@Log
public class Jtoken {
    public static void main(String[] args) {
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            String token = JWT.create()
                    .withIssuer("auth0")
                    .sign(algorithm);
            log.info(token);

            Map<String, Object> headerClaims = new HashMap<>();
            headerClaims.put("owner", "auth0");
            log.info(JWT.create().withHeader(headerClaims).sign(algorithm));

            log.info(
                    JWT.create()
                            .withClaim("array", Arrays.asList(new Integer[]{1, 2, 3}))
                            .sign(algorithm)
            );

            String user = JWT.create()
                    .withClaim("username", "admin")
                    .withClaim("role", "admin")
                    .withClaim("register_datetime", LocalDateTime.now() + "")
                    .sign(algorithm);
            log.info(user);
        } catch (JWTCreationException exception) {
            throw new IllegalStateException(exception);
        }
    }
}
