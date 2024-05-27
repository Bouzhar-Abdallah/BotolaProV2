package Bouzhar.BotolaPro.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/dashboard")
public class DashboardController {
    @GetMapping(path = "/")
    @PreAuthorize("hasRole('ADMIN')")
    public String hello(){
        return "hello admin";
    }
}
