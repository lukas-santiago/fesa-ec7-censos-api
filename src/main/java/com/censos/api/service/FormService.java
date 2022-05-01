package com.censos.api.service;

import java.util.Collection;

import javax.transaction.Transactional;

import com.censos.api.entity.Form;
import com.censos.api.entity.User;
import com.censos.api.repository.FormRepository;
import com.censos.api.repository.UserRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class FormService {

    private final FormRepository formRepository;

    public Form create(Form form) {
        Form findUserByName = formRepository.findUserByName(form.getName());
        if (findUserByName != null) {
            throw new RuntimeException("Already form exists");
        }
        form.setId(null);
        log.debug("Creating Form:" + form);
        return formRepository.save(form);
    }

    public Collection<Form> list() {
        log.debug("Listing forms");
        return formRepository.findAll();
    }

    public Form get(Long id) {
        if (formRepository.findById(id).isEmpty())
            throw new RuntimeException("Form don't exists");

        log.debug("get form by id: " + id);
        return formRepository.findById(id).get();
    }

    public Form update(Form form) {
        if (formRepository.findById(form.getId()).isEmpty())
            throw new RuntimeException("Form don't exists");

        log.debug("updatting form: " + form);
        formRepository.save(form);
        return form;
    }

    public Boolean delete(Long id) {
        if (formRepository.findById(id).isEmpty())
            throw new RuntimeException("Form don't exists");

        log.debug("delete form by id: " + id);
        formRepository.deleteById(id);
        return true;
    }
}
