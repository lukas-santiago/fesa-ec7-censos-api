package com.censos.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.censos.api.entity.Form;
import com.censos.api.payload.FormDTO;
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
	public List<FormDTO> getAll() {
		return formService.list()
				.stream().map(form -> new FormDTO(form))
				.collect(Collectors.toList());
	}

	@PostMapping(value = "/")
	public FormDTO create(@RequestBody FormDTO formDTO) {
		Form form = new Form();
		form.setName(formDTO.getName());
		form.setName(formDTO.getName());
		form.setDescription(formDTO.getDescription());
		form.setExpiredAt(formDTO.getExpiredAt());
		return new FormDTO(formService.create(form));
	}

	@GetMapping(value = "/{id}")
	public FormDTO getOne(@PathVariable Long id) {
		return new FormDTO(formService.get(id));
	}

	@DeleteMapping(value = "/{id}")
	public Boolean deleteOne(@PathVariable Long id) {
		return formService.delete(id);
	}

	@PutMapping(value = "/")
	public FormDTO updateOne(@RequestBody FormDTO formDTO) {
		Form form = new Form();
		form.setId(formDTO.getId());
		form.setName(formDTO.getName());
		form.setDescription(formDTO.getDescription());
		form.setExpiredAt(formDTO.getExpiredAt());
		return new FormDTO(formService.update(form));
	}
}
