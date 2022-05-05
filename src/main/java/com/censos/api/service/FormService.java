package com.censos.api.service;

import java.util.List;

import javax.transaction.Transactional;

import com.censos.api.entity.Form;
import com.censos.api.entity.FormHead;
import com.censos.api.repository.FormRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class FormService {

    private final FormRepository formRepository;

    public Form create(FormHead formHead) {
        Form findUserByName = formRepository.findByName(formHead.getName());
        if (findUserByName != null) {
            throw new RuntimeException("Already form exists");
        }
        log.debug("Creating Form:" + formHead);

        Form form = new Form(formHead.getId(), formHead.getCode(), formHead.getName(), formHead.getDescription(),
                formHead.getExpiredAt(), formHead.getUserId(), null);
        return formRepository.save(form);
    }

    public List<Form> list() {
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
