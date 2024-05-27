package Bouzhar.BotolaPro.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {
    @GetMapping(path = "/")
    @PreAuthorize("hasAuthority('SCOPE_ROLE_USER')")
    public String hello(){
        SecurityContextHolder.getContext().getAuthentication().getAuthorities().forEach(System.out::println);
        return "hello user";
    }
}
