package com.nashtech.backend.data.repositories;

import com.nashtech.backend.constant.AccountRole;
import com.nashtech.backend.data.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(AccountRole name);
}
