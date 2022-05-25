package com.censos.api.repository;

import java.util.List;

import com.censos.api.entity.Form;
import com.censos.api.entity.FormField;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FormFieldRepository extends JpaRepository<FormField, Long> {
    public List<FormField> findAllByForm(Form form);

    public FormField findByFieldId(Long fieldId);
}
