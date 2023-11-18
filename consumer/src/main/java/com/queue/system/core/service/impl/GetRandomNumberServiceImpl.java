package com.queue.system.core.service.impl;

import org.springframework.stereotype.Service;

import com.queue.system.core.domain.RandomNumberDomain;
import com.queue.system.core.service.GetRandomNumberService;
import com.queue.system.integration.client.ProviderClient;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GetRandomNumberServiceImpl implements GetRandomNumberService {

	private final ProviderClient providerClient;
	
	@Override
	public RandomNumberDomain getRandomNumber(Long userId) {
		return providerClient.getGeneratedNumber().toDomain();
	}
}