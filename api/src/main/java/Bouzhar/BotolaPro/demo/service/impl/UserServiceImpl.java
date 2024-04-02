package Bouzhar.BotolaPro.demo.service.impl;

import Bouzhar.BotolaPro.demo.Enum.TokenType;
import Bouzhar.BotolaPro.demo.entity.Token;
import Bouzhar.BotolaPro.demo.entity.User;
import Bouzhar.BotolaPro.demo.exception.ResourceNotCreatedException;
import Bouzhar.BotolaPro.demo.exception.ResourceNotFoundException;
import Bouzhar.BotolaPro.demo.repository.TokenRepository;
import Bouzhar.BotolaPro.demo.repository.UserRepository;
import Bouzhar.BotolaPro.demo.service.contract.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;
import java.util.UUID;

/**
 * Service class for managing user-related operations.
 *
 * <p>This service class provides methods for retrieving user data based on various criteria,
 * updating user information, and handling user status changes.</p>
 *
 * @author <a href="mailto:ouharrioutman@gmail.com">Ouharri Outman</a>
 * @version 1.0
 */
@Slf4j
@Service
@Validated
@RequiredArgsConstructor
@CacheConfig(cacheNames = "Users")
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;

    public User saveUser(User user) {
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            throw new ResourceNotCreatedException("User not created");
        }
    }


    /**
     * Retrieves a user by email.
     *
     * @param email The email of the user to retrieve.
     * @return Optional containing the user if found, otherwise empty.
     */
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    /**
     * Retrieves a user by ID.
     *
     * @param username The ID of the user to retrieve.
     * @return Optional containing the user if found, otherwise empty.
     */
    public Optional<User> findById(UUID username) {
        return userRepository.findById(username);
    }


    /**
     * Saves a new user token to the database.
     *
     * @param user     User for whom the token is generated
     * @param jwtToken JWT token to be saved
     */
    public void saveUserToken(User user, String jwtToken) {
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }

    /**
     * Revokes all valid tokens for a user by marking them as expired and revoked.
     *
     * @param user User for whom tokens are revoked
     */
    public void revokeAllUserTokens(User user) {
        var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
        if (!validUserTokens.isEmpty()) {
            validUserTokens.forEach(token -> {
                token.setExpired(true);
                token.setRevoked(true);
            });
            tokenRepository.saveAll(validUserTokens);
        }
    }
}