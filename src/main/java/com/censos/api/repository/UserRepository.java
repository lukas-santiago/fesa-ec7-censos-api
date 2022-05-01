package com.censos.api.repository;

import com.censos.api.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByEmail(String email);
}
