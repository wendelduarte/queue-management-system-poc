package com.queue.system.view.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.queue.system.view.dto.request.UserRequestDTO;
import com.queue.system.view.dto.response.UserResponseDTO;

@RequestMapping("/users")
public interface UserController {

	@GetMapping("/{userId}")
	UserResponseDTO getUserById(@PathVariable(name = "userId") Long userId);
	
	@PostMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void saveUser(@RequestBody UserRequestDTO user);
	
}
