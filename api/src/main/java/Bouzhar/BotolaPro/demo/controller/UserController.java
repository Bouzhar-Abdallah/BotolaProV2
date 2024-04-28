package Bouzhar.BotolaPro.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {
    @GetMapping(path = "/")
    @PreAuthorize("hasRole('USER')")
    public String hello(){
        return "hello user";
    }
}
