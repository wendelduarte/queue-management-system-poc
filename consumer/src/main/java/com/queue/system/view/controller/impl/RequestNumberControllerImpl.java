package com.queue.system.view.controller.impl;

import org.springframework.web.bind.annotation.RestController;

import com.queue.system.core.service.GetRandomNumberService;
import com.queue.system.view.controller.RequestNumberController;
import com.queue.system.view.dto.response.NumberResponseDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class RequestNumberControllerImpl implements RequestNumberController {

	private final GetRandomNumberService getRandomNumberService;
	
	@Override
	public NumberResponseDTO getRandomNumberForUser(Long userId) {
		return new NumberResponseDTO(getRandomNumberService.getRandomNumber(userId).number());
	}
}