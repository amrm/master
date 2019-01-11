package org.example.com.demo.core.security.repo;

import org.example.com.demo.core.security.model.Role;
import org.example.com.demo.core.security.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


/**
 * @author :Amr Abdeldayem
 */

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}