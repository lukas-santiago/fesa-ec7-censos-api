package com.censos.api.service;

import java.util.List;

import javax.transaction.Transactional;

import com.censos.api.entity.Form;
import com.censos.api.repository.FormRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class FormService {

    private final FormRepository formRepository;

    public Form create(Form form) {
        Form findUserByName = formRepository.findByName(form.getName());
        if (findUserByName != null) {
            throw new RuntimeException("Form already exists");
        }
        return formRepository.save(form);
    }

    public List<Form> list() {
        return formRepository.findAll();
    }

    public Form get(Long id) {
        if (formRepository.findById(id).isEmpty())
            throw new RuntimeException("Form don't exists");

        return formRepository.findById(id).get();
    }

    public Form update(Form form) {
        if (formRepository.findById(form.getId()).isEmpty())
            throw new RuntimeException("Form don't exists");

        formRepository.save(form);
        return form;
    }

    public Boolean delete(Long id) {
        if (formRepository.findById(id).isEmpty())
            throw new RuntimeException("Form don't exists");

        formRepository.deleteById(id);
        return true;
    }
}
