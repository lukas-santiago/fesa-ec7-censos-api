package com.censos.api.controller;

import java.util.List;

import com.censos.api.entity.Field;
import com.censos.api.entity.FormField;
import com.censos.api.service.FieldService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/field")
@RequiredArgsConstructor
public class FieldController {

    private final FieldService fieldService;

    @GetMapping(value = "/")
    public List<Field> getAll() {
        return fieldService.list();
    }

    @GetMapping(value = "/{id}")
    public Field getOne(@PathVariable Long id) {
        return fieldService.get(id);
    }
}
