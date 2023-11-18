package com.queue.system.view.controller.impl;

import org.springframework.web.bind.annotation.RestController;

import com.queue.system.core.domain.UserDomain;
import com.queue.system.core.service.GetUserService;
import com.queue.system.core.service.SaveUserService;
import com.queue.system.view.controller.UserController;
import com.queue.system.view.dto.request.UserRequestDTO;
import com.queue.system.view.dto.response.UserResponseDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController{

	private final GetUserService getUserService;
	private final SaveUserService saveUserService;

	@Override
	public UserResponseDTO getUserById(Long userId) {
		return getUserService.execute(userId).toUserResponseDTO();
	}

	@Override
	public void saveUser(UserRequestDTO user) {
		saveUserService.saveUser(UserDomain.builder().name(user.name()).age(user.age()).build());
		
	}	
}