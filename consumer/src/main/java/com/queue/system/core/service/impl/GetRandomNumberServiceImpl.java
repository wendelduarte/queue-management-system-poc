package com.queue.system.core.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.queue.system.core.domain.RandomNumberDomain;
import com.queue.system.core.exception.BasicException;
import com.queue.system.core.service.GetRandomNumberService;
import com.queue.system.integration.client.ProviderClient;

import feign.FeignException;
import io.github.resilience4j.retry.annotation.Retry;
import io.micrometer.core.instrument.Counter;
import lombok.RequiredArgsConstructor;

@Service
public class GetRandomNumberServiceImpl implements GetRandomNumberService {

	private final Counter allCallsToEndpointRandom;
	private final Counter callsWithErrorToEndpointRandom;
	private final ProviderClient providerClient;
	
	public GetRandomNumberServiceImpl(@Qualifier("allCallsToEndpointRandom") Counter allCallsToEndpointRandom, 
			@Qualifier("callsWithErrorToEndpointRandom") Counter callsWithErrorToEndpointRandom, ProviderClient providerClient) {
		this.allCallsToEndpointRandom = allCallsToEndpointRandom;
		this.callsWithErrorToEndpointRandom = callsWithErrorToEndpointRandom;
		this.providerClient = providerClient;
	}
	
	@Override
	@Retry(name = "getRandomNumber", fallbackMethod = "getRandomNumberFallback")
	public RandomNumberDomain getRandomNumber(Long userId) {
		allCallsToEndpointRandom.increment();
		return providerClient.getGeneratedNumber().toDomain();
	}
	
	public RandomNumberDomain getRandomNumberFallback(Long userId, FeignException exception) {
		callsWithErrorToEndpointRandom.increment();
		throw new BasicException(exception);
	}
}