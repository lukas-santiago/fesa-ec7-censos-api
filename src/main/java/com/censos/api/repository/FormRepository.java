package com.censos.api.repository;

import com.censos.api.entity.Form;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FormRepository extends JpaRepository<Form, Long> {
    
    Form findUserByName(String name);
}
