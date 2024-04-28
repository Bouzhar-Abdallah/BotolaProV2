package Bouzhar.BotolaPro.demo.service;

import Bouzhar.BotolaPro.demo.entity.AppUser;
import Bouzhar.BotolaPro.demo.repository.AppUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

//@Service
public class UserService implements UserDetailsService {
    private AppUserRepository appUserRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(AppUserRepository appUserRepository, PasswordEncoder passwordEncoder) {
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("from user service : " + username);
        return appUserRepository.findAppUserByUsername(username).orElseThrow(() -> new UsernameNotFoundException("user not found"));
    }
}
