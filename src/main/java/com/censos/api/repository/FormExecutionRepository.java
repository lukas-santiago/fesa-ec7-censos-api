package com.censos.api.repository;

import java.util.Collection;
import java.util.Optional;

import com.censos.api.entity.FormExecution;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FormExecutionRepository extends JpaRepository<FormExecution, Long> {

    Collection<FormExecution> findAllByFormId(Long formId);
    Optional<FormExecution> findAllByFormFieldId(Long formFieldId);

    
    @Query(value = "SELECT * FROM form_execution f WHERE f.created_by = ?1 AND f.form_id = ?2", nativeQuery = true)
    Collection<FormExecution> findAllByUserAndByFormId(String createdBy, Long formId);
}
