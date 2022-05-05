package com.censos.api.service;

import java.util.List;

import javax.transaction.Transactional;

import com.censos.api.entity.FormField;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
// @Slf4j
public class FormFieldService {
    // private final FormFieldRepository formFieldRepository;

    public List<FormField> list(Long formId) {
        return null;
    }

    public FormField create(FormField formField) {
        return null;
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

}
