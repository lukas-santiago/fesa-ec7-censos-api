package com.censos.api.controller;

import java.util.List;

import com.censos.api.entity.FormField;
import com.censos.api.payload.FormFieldDTO;
import com.censos.api.service.FormFieldService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/formField")
@RequiredArgsConstructor
public class FormFieldController {
	private final FormFieldService formFieldService;

	@GetMapping(value = "/")
	public List<FormField> getAll(Long formId) {
		return formFieldService.list(formId);
	}

	@PostMapping(value = "/")
	public FormField create(@RequestBody FormFieldDTO formFieldDTO) {
		return formFieldService.create(formFieldDTO);
	}

	// @PostMapping(value = "/")
	// public FormField createMany(@RequestBody List<FormField> formFields) {
	// return formFieldService.createMany(formFields);
	// }

	@GetMapping(value = "/{id}")
	public FormField getOne(@PathVariable Long id) {
		return formFieldService.get(id);
	}

	@DeleteMapping(value = "/{id}")
	public Boolean deleteOne(@PathVariable Long id) {
		return formFieldService.delete(id);
	}

	@PutMapping(value = "/")
	public FormField updateOne(@RequestBody FormField formField) {
		return formFieldService.update(formField);
	}

	// @RequestMapping(method = RequestMethod.PUT, value = "/")
	// public FormField updateMany(@RequestBody List<FormField> formFields) {
	// return formFieldService.updateMany(formFields);
	// }
}
