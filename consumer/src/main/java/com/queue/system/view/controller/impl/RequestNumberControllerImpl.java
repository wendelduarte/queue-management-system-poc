package com.queue.system.view.controller.impl;

import org.springframework.web.bind.annotation.RestController;

import com.queue.system.view.controller.RequestNumberController;
import com.queue.system.view.dto.response.NumberResponseDTO;

@RestController
public class RequestNumberControllerImpl implements RequestNumberController{

	@Override
	public NumberResponseDTO getRandomNumberForUser(Integer userId) {
		// TODO Auto-generated method stub
		return new NumberResponseDTO(1);
	}

}
