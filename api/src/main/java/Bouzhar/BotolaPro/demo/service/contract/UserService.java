package Bouzhar.BotolaPro.demo.service.contract;

import Bouzhar.BotolaPro.demo.dto.auth.ChangePasswordRequest;
import Bouzhar.BotolaPro.demo.dto.response.UserResponsesDto;
import Bouzhar.BotolaPro.demo.entity.User;
import org.springframework.security.authentication.AnonymousAuthenticationToken;

import java.security.Principal;
import java.util.Optional;
import java.util.UUID;

/**
 * Service interface for managing User entities.
 *
 * @author <a href="mailto:ouharri.outman@gmail.com">ouharri</a>
 */
public interface UserService {


    User saveUser(User user);

    /**
     * Retrieves a user by email.
     *
     * @param email The email of the user to retrieve.
     * @return Optional containing the user if found, otherwise empty.
     */
    User findByEmail(String email);


    /**
     * Revokes all valid tokens for a user by marking them as expired and revoked.
     *
     * @param user User for whom tokens are revoked
     */
    void revokeAllUserTokens(User user);

    /**
     * Saves a new user token to the database.
     *
     * @param user     User for whom the token is generated
     * @param jwtToken JWT token to be saved
     */
    void saveUserToken(User user, String jwtToken);

}