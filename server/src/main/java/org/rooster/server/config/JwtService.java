package org.rooster.server.config;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtService {
    private static final String SIGNING_KEY = "37d774535177913d462757c4fbde51eb550de545182d7bc8bf607203d7a2ae3d7525775cabcc8b05334f1006936b7725d23c645464558881043fbf901e30f892";
    private static final long ACCESS_TOKEN_EXPIRATION_TIME_MS = 1000 * 60 * 15;
    private static final long REFRESH_TOKEN_EXPIRATION_TIME_MS = 1000L * 60 * 60 * 24 * 30;

    public String generateAccessToken(UserDetails userDetails) {
        return generateAccessToken(new HashMap<>(), userDetails);
    }

    public String generateAccessToken(Map<String, Object> extraClaims, UserDetails userDetails) {
        return buildToken(extraClaims, userDetails, ACCESS_TOKEN_EXPIRATION_TIME_MS);
    }

    public String generateRefreshToken(UserDetails userDetails) {
        return buildToken(new HashMap<>(), userDetails, REFRESH_TOKEN_EXPIRATION_TIME_MS);
    }

    public String buildToken(
            Map<String, Object> extraClaims,
            UserDetails userDetails,
            long expirationTimeMs) {
        return Jwts.builder()
                .claims(extraClaims)
                .subject(userDetails.getUsername())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + expirationTimeMs))
                .signWith(getSecretSigningKey(), Jwts.SIG.HS256)
                .compact();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return username.equals(userDetails.getUsername()) && isExpired(token);
    }

    public boolean isExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsLambdaFunction) {
        return claimsLambdaFunction.apply(extractAllClaims(token));
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getSecretSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private SecretKey getSecretSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SIGNING_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
