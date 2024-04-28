package Bouzhar.BotolaPro.demo.repository;

import Bouzhar.BotolaPro.demo.entity.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
    //AppRole findAppRoleByAuthority(String authority);
    Optional<AppRole> findAppRoleByAuthority(String authority);
}
