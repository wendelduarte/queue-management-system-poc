package com.queue.system.view.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.queue.system.view.dto.response.NumberResponseDTO;

@RequestMapping("/random/number")
public interface RequestNumberController {

	@GetMapping("/{userId}")
	NumberResponseDTO getRandomNumberForUser(@PathVariable(name = "userId") Long userId);
}
