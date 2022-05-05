package com.censos.api.repository;

import com.censos.api.entity.Field;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FieldRepository extends JpaRepository<Field, Long> {
}
