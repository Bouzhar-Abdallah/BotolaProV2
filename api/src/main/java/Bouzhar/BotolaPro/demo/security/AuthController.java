package Bouzhar.BotolaPro.demo.security;

import Bouzhar.BotolaPro.demo.dto.RegistrationDto;
import Bouzhar.BotolaPro.demo.entity.AppRole;
import Bouzhar.BotolaPro.demo.entity.AppUser;
import Bouzhar.BotolaPro.demo.repository.AppRoleRepository;
import Bouzhar.BotolaPro.demo.repository.AppUserRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/auth")
@CrossOrigin("*")
public class AuthController {

    public AuthController(AuthenticationManager authenticationManager, JwtEncoder jwtEncoder, PasswordEncoder passwordEncoder, AppUserRepository appUserRepository, AppRoleRepository appRoleRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtEncoder = jwtEncoder;
        this.passwordEncoder = passwordEncoder;
        this.appUserRepository = appUserRepository;
        this.appRoleRepository = appRoleRepository;
    }

    private final AuthenticationManager authenticationManager;
    private final JwtEncoder jwtEncoder;
    private final PasswordEncoder passwordEncoder;
    private final AppUserRepository appUserRepository;
    private final AppRoleRepository appRoleRepository;


    public Map<String, String> generateToken(String email, String password) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        String scope = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(" "));
        Instant now = Instant.now();
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuedAt(now)
                .expiresAt(now.plus(120, ChronoUnit.MINUTES))
                .subject(email)
                .issuer("http://localhost:8082")
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

    @PostMapping(path = "/login")
    public Map<String, String> login(String username, String password) {

        return generateToken(username, password);
    }


    @PostMapping(path = "/register")
    public Map<String, String> register(@RequestBody RegistrationDto registrationDto) {
        AppUser appUser = new AppUser();
        appUser.setEmail(registrationDto.getEmail());
        appUser.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        appUser.setFirstName(registrationDto.getFirstName());
        appUser.setLastName(registrationDto.getLastName());
        appUser.setNumeroTel(registrationDto.getPhoneNumber());

        AppRole role = appRoleRepository.findAppRoleByAuthority("USER").get();
        appUser.getRoles().add(role);


        appUserRepository.save(appUser);

        return generateToken(appUser.getEmail(), appUser.getPassword());
    }


}
