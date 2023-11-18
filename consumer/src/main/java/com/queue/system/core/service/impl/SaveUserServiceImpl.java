package com.queue.system.core.service.impl;

import org.springframework.stereotype.Service;

import com.queue.system.core.domain.UserDomain;
import com.queue.system.core.service.SaveUserService;
import com.queue.system.database.entity.UserEntity;
import com.queue.system.database.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SaveUserServiceImpl implements SaveUserService{

	private final UserRepository userRepository;
	
	@Override
	public void saveUser(UserDomain user) {
		userRepository.save(new UserEntity(user.name(), user.age()));
	}	
}