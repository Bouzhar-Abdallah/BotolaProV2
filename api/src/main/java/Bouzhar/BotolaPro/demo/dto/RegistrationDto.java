package Bouzhar.BotolaPro.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationDto {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String password;
}
