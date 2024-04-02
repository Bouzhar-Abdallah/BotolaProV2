package Bouzhar.BotolaPro.demo.entity.embeddables;

import Bouzhar.BotolaPro.demo.entity.Event;
import Bouzhar.BotolaPro.demo.entity.Post;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
public class PostEvent implements Serializable {
    @ManyToOne
    private Post post;
    @ManyToOne
    private Event event;
}
