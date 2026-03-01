package org.example.lunaris.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import java.util.Date;

@Service
public class JwtService {

    @Value("${jwt.private-key}")
    private String privateKeyString;

    private final CustomUserDetailsService userDetailsService;

    public JwtService(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
    public String generarToken(Authentication authentication)
            throws Exception {

        UserDetails user =
                (UserDetails) authentication.getPrincipal();

        String role = user.getAuthorities()
                .iterator()
                .next()
                .getAuthority()
                .replace("ROLE_", "");

        PrivateKey privateKey = carregarPrivateKey();

        Date now = new Date();
        Date expiry = new Date(now.getTime() + 3600000);

        Long userId = userDetailsService.buscarIdUsuario(user.getUsername());

        return Jwts.builder()
                .setSubject(user.getUsername())
                .claim("role", role)
                .claim("userId", userId)
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(privateKey, SignatureAlgorithm.RS256)
                .compact();
    }

    private PrivateKey carregarPrivateKey() throws Exception {
        byte[] decoded = Base64.getDecoder().decode(privateKeyString);

        PKCS8EncodedKeySpec spec =
                new PKCS8EncodedKeySpec(decoded);

        KeyFactory kf = KeyFactory.getInstance("RSA");

        return kf.generatePrivate(spec);
    }
}

