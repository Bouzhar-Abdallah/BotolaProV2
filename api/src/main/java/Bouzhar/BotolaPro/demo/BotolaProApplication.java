package Bouzhar.BotolaPro.demo;

import Bouzhar.BotolaPro.demo.entity.AppRole;
import Bouzhar.BotolaPro.demo.entity.AppUser;
import Bouzhar.BotolaPro.demo.repository.AppRoleRepository;
import Bouzhar.BotolaPro.demo.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class BotolaProApplication {

    public static void main(String[] args) {
        SpringApplication.run(BotolaProApplication.class, args);
    }

    @Bean
    CommandLineRunner start(AppRoleRepository appRoleRepository, AppUserRepository appUserRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            //appUserRepository.save(new AppUser(1L,"","","","",true, new HashSet<>()));
            Set<AppRole> adminRoles = new HashSet<>();
            adminRoles.add(appRoleRepository.findAppRoleByAuthority("ADMIN").get());

            AppUser admin = new AppUser(1L, "admin", "admin@gmail.com", passwordEncoder.encode("password"), true, adminRoles);
            if (appUserRepository.findByEmail("admin").isEmpty()) appUserRepository.save(admin);


            Set<AppRole> userRoles = new HashSet<>();
            userRoles.add(appRoleRepository.findAppRoleByAuthority("USER").get());

            AppUser user = new AppUser(1L, "user", "user@gmail.com", passwordEncoder.encode("password"), true, userRoles);
            if (appUserRepository.findByEmail("user").isEmpty()) appUserRepository.save(user);

            Set<AppRole> redactorRoles = new HashSet<>();
            redactorRoles.add(appRoleRepository.findAppRoleByAuthority("REDACTOR").get());

            AppUser redactor = new AppUser(1L, "redactor", "redactor@gmail.com", passwordEncoder.encode("password"), true, redactorRoles);
            if (appUserRepository.findByEmail("redactor").isEmpty()) appUserRepository.save(redactor);


            if (appRoleRepository.findAppRoleByAuthority("ADMIN").isPresent()) return;
            appRoleRepository.save(new AppRole("ADMIN"));
            if (appRoleRepository.findAppRoleByAuthority("USER").isPresent()) return;
            appRoleRepository.save(new AppRole("USER"));



        };
    }
}
