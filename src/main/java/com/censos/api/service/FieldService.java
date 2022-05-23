package com.censos.api.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.censos.api.entity.Field;
import com.censos.api.repository.FieldRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class FieldService {
    private final FieldRepository fieldRepository;

    public List<Field> list() {
        return fieldRepository.findAll();
    }

    public Field get(Long id) {
        Optional<Field> field = fieldRepository.findById(id);
        if (field.isEmpty())
            throw new RuntimeException("Field don't exists");

        return field.get();
    }

    public Field get(String type) {
        Optional<Field> field = fieldRepository.findByType(type);
        if (field.isEmpty())
            throw new RuntimeException("Field don't exists");

        return field.get();
    }
}
