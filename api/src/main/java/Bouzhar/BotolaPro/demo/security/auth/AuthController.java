package Bouzhar.BotolaPro.demo.security.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {
    private AuthenticationManager authenticationManager;
    private JwtEncoder jwtEncoder;

    public AuthController(AuthenticationManager authenticationManager, JwtEncoder jwtEncoder) {
        this.authenticationManager = authenticationManager;
        this.jwtEncoder = jwtEncoder;
    }

    @PostMapping(path = "/login")
    public Map<String, String> login(String username, String password) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        String scope = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(" "));
        Instant now = Instant.now();
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuedAt(now.plus(10, ChronoUnit.MINUTES))
                .subject(username)
                .issuer("BotolaPro")
                .claim("scope", scope)
                .build();
        JwtEncoderParameters jwtEncoderParameters =
                JwtEncoderParameters.from(
                        JwsHeader.with(MacAlgorithm.HS512).build(),
                        claims
                );
        String jwt = jwtEncoder.encode(jwtEncoderParameters).getTokenValue();
        return Map.of("access-token", jwt);
    }

    @PostMapping(path = "/register")
    public String register() {
        return "register";
    }

    @GetMapping(path = "/profile")
    public Authentication authentication(Authentication authentication) {
        return authentication;
    }
}
