package com.censos.api.repository;

import java.util.Optional;

import com.censos.api.entity.Field;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FieldRepository extends JpaRepository<Field, Long> {
    Optional<Field> findByType(String type);

}
