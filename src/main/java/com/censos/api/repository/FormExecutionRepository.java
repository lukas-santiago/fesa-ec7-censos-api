package com.censos.api.repository;

import java.util.Collection;
import java.util.Optional;

import com.censos.api.entity.FormExecution;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FormExecutionRepository extends JpaRepository<FormExecution, Long> {

    Collection<FormExecution> findAllByFormId(Long formId);
    Optional<FormExecution> findAllByFormFieldId(Long formFieldId);
}
