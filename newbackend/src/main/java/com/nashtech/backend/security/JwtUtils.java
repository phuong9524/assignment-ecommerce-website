package com.nashtech.backend.security;

import com.nashtech.backend.services.impl.UserDetailsImpl;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Component
public class JwtUtils {

    @Value("${nashtech.app.jwtSecret}")
    private String jwtSecret;

    @Value("${nashtech.app.jwtExpiration}")
    private String jwtExpiration;

    public String generateJwtToken(Authentication authentication) {
        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
        LocalDate localDate = LocalDate.parse(jwtExpiration, DateTimeFormatter.BASIC_ISO_DATE);
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        return Jwts.builder()
                .setSubject((userPrincipal.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(date)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
        return true;
    }


}
