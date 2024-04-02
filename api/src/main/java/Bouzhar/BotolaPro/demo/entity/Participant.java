package Bouzhar.BotolaPro.demo.entity;

import jakarta.persistence.Entity;

@Entity

public class Participant extends User {
    private Integer remainingBudget;
    private boolean isActive;
}
