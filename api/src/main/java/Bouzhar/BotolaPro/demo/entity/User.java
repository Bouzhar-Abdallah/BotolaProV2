package Bouzhar.BotolaPro.demo.entity;

import Bouzhar.BotolaPro.demo.Enum.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;



import java.util.Collection;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name = "users")
public class User  {


    @Id
    @GenericGenerator(name = "UUID")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String numeroTel;

    /**
     * The user's password.
     */
    @NotBlank(message = "password cannot be blank.")
    @Size(min = 8, message = "Password must be at least 8 characters long.")
    private String password;

    /**
     * The path to the user's image.
     */
    private String image;

    /**
     * The user's phone number.
     */
    @Pattern(regexp = "0\\d{9}", message = "Phone number must match the format '0XXXXXXXXX'")
    @Column(unique = true)
    private String phoneNumber;

    /**
     * The user's email address.
     */
    @Email(message = "Email was not provided")
    @Size(max = 80, message = "Email is too long")
    @Column(unique = true)
    private String email;

    /**
     * The user's first name.
     */
    @NotNull(message = "FirstName must be present")
    @Size(min = 1, message = "Firstname cannot be empty")
    @Size(max = 30, message = "Firstname is too long")
    private String firstName;

    /**
     * The user's last name.
     */
    @Size(max = 30, message = "Lastname is too long")
    private String lastName;

    /**
     * The nationality of the user.
     */
    private String nationality;

    /**
     * The birthdate of the user.
     */
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    /**
     * The user's role.
     */
    @Enumerated(EnumType.STRING)
    private Role role;

    /**
     * The list of tokens associated with the user.
     */
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Token> tokens;

    /**
     * Indicates whether the user's account is enabled.
     * A disabled account cannot be used for authentication.
     * Default value is {@code true}, meaning the account is enabled by default.
     */
    private boolean enabled = true;

    /**
     * Indicates whether the user's account is non-locked.
     * A locked account cannot be used for authentication, typically as a security measure.
     * Default value is {@code true}, meaning the account is non-locked (unlocked) by default.
     */
    private boolean accountNonLocked = true;

    /**
     * Return the authorities granted to the user.
     *
     * @return A collection of granted authorities.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getAuthorities();
    }

    /**
     * Returns the password used to authenticate the user.
     *
     * @return The user's password.
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * Returns the username used to authenticate the user.
     *
     * @return The user's email address.
     */
    @Override
    public String getUsername() {
        return getEmail();
    }

    /**
     * Indicates whether the user's account has expired.
     *
     * @return {@code true} if the user's account is valid (i.e., not expired),
     * {@code false} otherwise.
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user's credentials (password) have expired.
     *
     * @return {@code true} if the user's credentials are valid (i.e., not expired),
     * {@code false} otherwise.
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
}
