package com.sw.security;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Custom token generator class for generating and validating SW tokens.
 */
@Component
public class TokenProvider {

    Logger logger = LoggerFactory.getLogger(TokenProvider.class);

    @Value("${app.jwtSecret}")
    private String jwtSecret;

    @Value("${app.jwtExpirationInMs}")
    private int jwtExpirationInMs;

    /**
     * Generate JWT token based on authentication principal
     * @param authentication
     * @return
     */
    public String generateToken(Authentication authentication) {
        SWUserDetails userDetails = (SWUserDetails) authentication.getPrincipal();
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);
        String token = Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .setIssuer("StarWarsApp")
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
        logger.debug("Generated token for authentication of " + authentication.getPrincipal() + " : ===========================================" + token);
        return token;
    }

    /**
     * @param token
     * @return
     */
    public String getUserUsernameFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    /**
     * @param authToken
     * @return true if token validation based on jwtSecret is passed,false otherwise
     */
    public boolean validateToken(String authToken) {
        logger.debug("Starting validation for received JWT token "+authToken);
        try {
            Jwts.parser()
                    .setSigningKey(jwtSecret)
                    .parseClaimsJws(authToken);
            return true;
        } catch (SignatureException | IllegalArgumentException | UnsupportedJwtException | MalformedJwtException | ExpiredJwtException ex) {
            logger.error("Token validation failed  " + ex);
        }
        return false;
    }

}
