package Bouzhar.BotolaPro.demo.entity;

import jakarta.persistence.*;


import java.util.Collection;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name = "users")
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String numeroTel;
    private String password;
}
