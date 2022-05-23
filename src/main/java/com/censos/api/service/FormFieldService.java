package com.censos.api.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.censos.api.entity.Field;
import com.censos.api.entity.Form;
import com.censos.api.entity.FormField;
import com.censos.api.payload.FormFieldDTO;
import com.censos.api.repository.FormFieldRepository;
import com.censos.api.repository.FormRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
// @Slf4j
public class FormFieldService {
    private final FormFieldRepository formFieldRepository;
    private final FormService formService;
    private final FieldService fieldService;

    public List<FormField> list(Long formId) {
        return formFieldRepository.findAll();
    }

    public FormField create(FormFieldDTO formFieldDTO) {
        Form form = formService.get(formFieldDTO.getFormId());
        Field field = fieldService.get(formFieldDTO.getFieldId());
        FormField formField = new FormField(null, form, field, formFieldDTO.getDescription(), formFieldDTO.getData());

        return formFieldRepository.save(formField);
    }

    public FormField get(Long id) {
        return null;
    }

    public Boolean delete(Long id) {
        return null;
    }

    public FormField update(FormField formField) {
        return null;
    }

    public FormField createMany(List<FormField> formFields) {
        return null;
    }

    public FormField updateMany(List<FormField> formFields) {
        return null;
    }

}
