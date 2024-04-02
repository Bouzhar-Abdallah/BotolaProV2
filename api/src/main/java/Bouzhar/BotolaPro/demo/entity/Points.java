package Bouzhar.BotolaPro.demo.entity;

import Bouzhar.BotolaPro.demo.entity.embeddables.PostEvent;
import jakarta.persistence.*;

@Entity
public class Points {
    @EmbeddedId
    private PostEvent id;
    private Integer point;
}
