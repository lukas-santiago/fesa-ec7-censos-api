package com.censos.api.controller;

import java.util.List;

import com.censos.api.entity.User;
import com.censos.api.service.UserService;

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
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;

	@GetMapping(value = "/")
	public List<User> getAll() {
		return userService.list();
	}

	@PostMapping(value = "/")
	public User create(@RequestBody User user) {
		user.setId(null);
		return userService.create(user);
	}

	@GetMapping(value = "/{id}")
	public User getOne(@PathVariable Long id) {
		return userService.get(id);
	}

	@DeleteMapping(value = "/{id}")
	public Boolean deleteOne(@PathVariable Long id) {
		return userService.delete(id);
	}

	@PutMapping(value = "/")
	public User updateOne(@RequestBody User user) {
		return userService.update(user);
	}
}
