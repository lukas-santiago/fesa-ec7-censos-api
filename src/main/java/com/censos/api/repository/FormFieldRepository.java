package com.censos.api.repository;

import java.util.Collection;

import com.censos.api.entity.FormField;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FormFieldRepository extends JpaRepository<FormField, Long> {
    public Collection<FormField> findAllByForm(Long form);

    public FormField findByFieldId(Long fieldId);
}
