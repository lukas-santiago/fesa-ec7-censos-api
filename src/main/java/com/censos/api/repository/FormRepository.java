package com.censos.api.repository;

import java.util.List;

import com.censos.api.entity.Form;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FormRepository extends JpaRepository<Form, Long> {
    Form findByName(String name);
    
    @Query(value = "SELECT f FROM form f WHERE f.created_by = ?1", nativeQuery = true)
    List<Form> findAllByUser(String createdBy);
}
