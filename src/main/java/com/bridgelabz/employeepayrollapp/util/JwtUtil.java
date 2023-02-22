package com.bridgelabz.employeepayrollapp.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Component
public class JwtUtil {
    @Value("${app.secret}")
    private String secret;

    //Read Claims
//    public Claims getClaims(String token){
//        return Jwts.parser()
//                .setSigningKey(secret.getBytes())
//                .parseClaimsJws(token)
//                .getBody();
//    }


    //Generate token
//    public String generateToken(String subject){
//        Key key= new SecretKeySpec(Base64.getDecoder().decode(secret   ),
//                SignatureAlgorithm.HS256.getJcaName());
//        return Jwts.builder()
//                .setSubject(subject)
//                .setIssuer("BridgelabzSahilKhan")
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis()+ TimeUnit.MINUTES.toMillis(15)))
//                //.signWith(SignatureAlgorithm.ES384, secret.getBytes())
//                .signWith(key)
//                .compact();
//    }
    public String generateToken(String subject){
        Algorithm algo = Algorithm.HMAC256("Sahil");
        return JWT.create().withClaim("id_key", subject).sign(algo);
    }

//    public String generateToken() {
//        return Jwts.builder()
//                .claim("name", "Jane Doe")
//                .claim("email", "jane@example.com")
//                .setSubject("jane")
//                .setId(UUID.randomUUID().toString())
//                .setIssuedAt(Date.from(Instant.now()))
//                .setExpiration(Date.from(Instant.now().plus(5l, ChronoUnit.MINUTES)))
//                .compact();
//    }
    }
