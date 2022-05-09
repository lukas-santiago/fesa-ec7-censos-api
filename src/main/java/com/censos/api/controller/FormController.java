package com.censos.api.controller;

import java.time.LocalDateTime;
import java.util.List;

import com.censos.api.entity.Form;
import com.censos.api.service.FormService;

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
@RequestMapping("/api/form")
@RequiredArgsConstructor
public class FormController {
	private final FormService formService;

	@GetMapping(value = "/")
	public List<Form> getAll() {
		return formService.list();
	}

	@PostMapping(value = "/")
	public Form create(
			@RequestBody Long id,
			String code,
			String name,
			String description,
			LocalDateTime expiredAt,
			String createdBy) {

		Form form = new Form();
		form.setId(id);
		form.setCode(code);
		form.setName(name);
		form.setDescription(description);
		form.setExpiredAt(expiredAt);
		form.setCreatedBy(createdBy);
		return formService.create(form);
	}

	@GetMapping(value = "/{id}")
	public Form getOne(@PathVariable Long id) {
		return formService.get(id);
	}

	@DeleteMapping(value = "/{id}")
	public Boolean deleteOne(@PathVariable Long id) {
		return formService.delete(id);
	}

	@PutMapping(value = "/")
	public Form updateOne(@RequestBody Form form) {
		return formService.update(form);
	}
}
