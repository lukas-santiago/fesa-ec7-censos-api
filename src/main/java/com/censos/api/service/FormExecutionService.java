package com.censos.api.service;

import java.util.Collection;
import java.util.Optional;

import javax.transaction.Transactional;

import com.censos.api.entity.FormExecution;
import com.censos.api.payload.FormExecutionDTO;
import com.censos.api.repository.FormExecutionRepository;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class FormExecutionService {
    private final FormExecutionRepository formExecutionRepository;
    private final FormService formService;
    private final FormFieldService formFieldService;

    public Collection<FormExecution> getAll(Long formId) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        return formExecutionRepository.findAllByUserAndByFormId(username, formId);
    }

    public FormExecution create(FormExecutionDTO formExecutionDTO) {
        Long formId = formService.get(formExecutionDTO.getFormId()).getId();
        Long formfieldId = formFieldService.get(formExecutionDTO.getFormFieldId()).getId();
        Optional<FormExecution> savedFormExecution = formExecutionRepository
                .findAllByFormFieldId(formExecutionDTO.getFormFieldId());

        if (savedFormExecution.isPresent()) {

            FormExecution formExecution = savedFormExecution.get();
            formExecution.setAnswer(formExecutionDTO.getAnswer());
            return formExecutionRepository.save(formExecution);
        }
        FormExecution formExecution = new FormExecution();
        formExecution.setAnswer(formExecutionDTO.getAnswer());
        formExecution.setFormId(formId);
        formExecution.setFormFieldId(formfieldId);
        return formExecutionRepository.save(formExecution);
    }

    public Boolean delete(Long id) {
        formExecutionRepository.deleteById(id);

        return formExecutionRepository.existsById(id);
    }

}
