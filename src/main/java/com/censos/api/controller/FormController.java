package com.censos.api.controller;

import java.time.LocalDateTime;
import java.util.Map;

import javax.validation.Valid;

import com.censos.api.entity.Form;
import com.censos.api.entity.Response;
import com.censos.api.service.FormService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Response> getAll() {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("forms", formService.list()))
                        .message("Forms retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }

    @PostMapping(value = "/")
    public ResponseEntity<Response> create(@RequestBody @Valid Form form) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("form", formService.create(form)))
                        .message("Form created")
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .build());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Response> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("form", formService.get(id)))
                        .message("Form retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Response> deleteOne(@PathVariable Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("deleted", formService.delete(id)))
                        .message("Form deleted")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }

    @PutMapping(value = "/")
    public ResponseEntity<Response> updateOne(@RequestBody @Valid Form form) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("form", formService.update(form)))
                        .message("Form updated")
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .build());
    }
}
