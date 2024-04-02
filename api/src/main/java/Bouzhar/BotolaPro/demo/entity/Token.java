package Bouzhar.BotolaPro.demo.entity;

import Bouzhar.BotolaPro.demo.Enum.TokenType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

/**
 * Represents a token entity used for authentication and authorization.
 *
 * @author <a href="mailto:ouharrioutman@gmail.com">Ouharri Outman</a>
 * @version 2.0
 */
@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Token {
    @Id
    @GenericGenerator(name = "UUID")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;


    /**
     * The token string, unique within the system.
     */
    @Column(unique = true, length = 1000)
    public String token;

    /**
     * The type of the token, e.g., Bearer.
     */
    @Enumerated(EnumType.STRING)
    public TokenType tokenType = TokenType.BEARER;

    /**
     * Indicates whether the token has been revoked.
     */
    public boolean revoked;

    /**
     * Indicates whether the token has expired.
     */
    public boolean expired;

    /**
     * The user associated with the token.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    public User user;
}