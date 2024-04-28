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
            Set<AppRole> roles = new HashSet<>();
            roles.add(appRoleRepository.findAppRoleByAuthority("ADMIN").get());
            roles.add(appRoleRepository.findAppRoleByAuthority("USER").get());

            AppUser admin = new AppUser(1L, "admin", "admin", passwordEncoder.encode("admin"), true, roles);
            if (appUserRepository.findByEmail("admin").isEmpty()) appUserRepository.save(admin);


            if (appRoleRepository.findAppRoleByAuthority("ADMIN").isPresent()) return;
            appRoleRepository.save(new AppRole("ADMIN"));
            if (appRoleRepository.findAppRoleByAuthority("USER").isPresent()) return;
            appRoleRepository.save(new AppRole("USER"));



        };
    }
}
