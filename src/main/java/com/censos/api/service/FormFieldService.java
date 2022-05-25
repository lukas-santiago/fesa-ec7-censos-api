package com.censos.api.service;

import java.util.List;

import javax.transaction.Transactional;

import com.censos.api.entity.Field;
import com.censos.api.entity.Form;
import com.censos.api.entity.FormField;
import com.censos.api.payload.FormFieldDTO;
import com.censos.api.repository.FormFieldRepository;

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
        Form form = formService.get(formId);
        return formFieldRepository.findAllByForm(form);
    }

    public FormField create(FormFieldDTO formFieldDTO) {
        Form form = formService.get(formFieldDTO.getFormId());
        Field field = fieldService.get(formFieldDTO.getFieldId());
        FormField formField = new FormField(null, form, field, formFieldDTO.getDescription(), formFieldDTO.getData());
        return formFieldRepository.save(formField);
    }

    public FormField get(Long id) {
        if (formFieldRepository.findById(id).isEmpty())
            throw new RuntimeException("Form Field don't exists");

        return formFieldRepository.findById(id).get();
    }

    public Boolean delete(Long id) {
        formFieldRepository.deleteById(id);

        return formFieldRepository.existsById(id);
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
