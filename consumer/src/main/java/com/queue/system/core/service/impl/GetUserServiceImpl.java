package com.queue.system.core.service.impl;

import org.springframework.stereotype.Service;

import com.queue.system.core.domain.UserDomain;
import com.queue.system.core.service.GetUserService;
import com.queue.system.database.entity.UserEntity;
import com.queue.system.database.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GetUserServiceImpl implements GetUserService{

	private final UserRepository userRepository;

	@Override
	public UserDomain execute(Long userId) {
		return userRepository.findById(userId)
				.map(UserEntity::toDomain)
				.orElseThrow();
	}
}