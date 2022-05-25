package com.censos.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.censos.api.payload.FieldDTO;
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
    public List<FieldDTO> getAll() {
        return fieldService.list().stream().map(field -> new FieldDTO(field)).collect(Collectors.toList());
    }

    @GetMapping(value = "/{id}")
    public FieldDTO getOne(@PathVariable Long id) {
        return new FieldDTO(fieldService.get(id));
    }
}
