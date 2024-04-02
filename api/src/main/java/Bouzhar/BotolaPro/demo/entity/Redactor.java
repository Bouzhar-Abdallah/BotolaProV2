package Bouzhar.BotolaPro.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

//@Entity
@Getter
@Setter
public class Redactor {
    /*@Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;*/
    private LocalDate joinDate;
    private boolean isActive;
}
