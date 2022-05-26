package com.censos.api.controller;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.censos.api.entity.FormExecution;
import com.censos.api.entity.FormField;
import com.censos.api.entity.StringResponse;
import com.censos.api.payload.FormFieldDTO;
import com.censos.api.service.FormExecutionService;
import com.censos.api.service.FormFieldService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/formField")
@RequiredArgsConstructor
public class FormFieldController {
	private final FormFieldService formFieldService;
	private final FormExecutionService formExecutionService;

	@GetMapping(value = "/")
	public List<FormFieldDTO> getAll(@RequestParam(name = "formId") Long formId) {
		return formFieldService.list(formId)
				.stream().map(formField -> new FormFieldDTO(formField))
				.collect(Collectors.toList());
	}

	@PostMapping(value = "/")
	public FormFieldDTO create(@RequestBody FormFieldDTO formFieldDTO) {
		System.out.println("\n\n\n" + formFieldDTO);
		return new FormFieldDTO(formFieldService.create(formFieldDTO));
	}

	@PostMapping(value = "/many/{formId}")
	public StringResponse create(@RequestBody List<FormFieldDTO> formFieldsDTO, @PathVariable Long formId) {
		System.out.println("\n\n\n" + formFieldsDTO.iterator().toString());
		List<FormField> formFieldsToDelete = formFieldService.list(formId);
		formFieldsToDelete.forEach( ff -> formFieldService.delete(ff.getId()));
		
		Collection<FormExecution> allFormExecution = formExecutionService.getAll(formId);
		allFormExecution.forEach(fe  -> formExecutionService.delete(fe.getId()));

		formFieldsDTO.forEach(ff -> formFieldService.create(ff));

		return new StringResponse("Many formFields created");
	}

	// @PostMapping(value = "/")
	// public FormField createMany(@RequestBody List<FormField> formFields) {
	// return formFieldService.createMany(formFields);
	// }

	@GetMapping(value = "/{id}")
	public FormFieldDTO getOne(@PathVariable Long id) {
		return new FormFieldDTO(formFieldService.get(id));
	}

	@DeleteMapping(value = "/{id}")
	public Boolean deleteOne(@PathVariable Long id) {
		return formFieldService.delete(id);
	}

	@PutMapping(value = "/")
	public FormFieldDTO updateOne(@RequestBody FormField formField) {
		return new FormFieldDTO(formFieldService.update(formField));
	}

	// @RequestMapping(method = RequestMethod.PUT, value = "/")
	// public FormField updateMany(@RequestBody List<FormField> formFields) {
	// return formFieldService.updateMany(formFields);
	// }
}
