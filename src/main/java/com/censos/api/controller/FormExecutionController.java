package com.censos.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.censos.api.payload.FormExecutionDTO;
import com.censos.api.service.FormExecutionService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/formExecution")
@RequiredArgsConstructor
public class FormExecutionController {
    private final FormExecutionService formExecutionService;

    @GetMapping(value = "/")
    public List<FormExecutionDTO> getAll(@RequestParam(name = "formId") Long formId) {
        return formExecutionService.getAll(formId).stream()
                .map(formExecution -> new FormExecutionDTO(formExecution))
                .collect(Collectors.toList());

        // return null;
    }
    @PostMapping(value = "/")
	public FormExecutionDTO create(@RequestBody FormExecutionDTO formExecutionDTO) {
        // return null;
		return new FormExecutionDTO(formExecutionService.create(formExecutionDTO));
	}
    @DeleteMapping(value = "/{id}")
	public Boolean deleteOne(@PathVariable Long id) {
        // return null;
		return formExecutionService.delete(id);
	}
}
