package Bouzhar.BotolaPro.demo.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * The parent for all exceptions, associated with resources, such as {@link Bouzhar.BotolaPro.demo.entity.User} etc.
 *
 * @author Ouharri Outman
 * @version 1.0
 */
@RestControllerAdvice
public class ResourceException extends RuntimeException {
    public ResourceException() {
    }

    public ResourceException(String message) {
        super(message);
    }
}
