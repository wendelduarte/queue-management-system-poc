package com.queue.system.core.service.impl;

import org.springframework.stereotype.Service;

import com.queue.system.core.domain.RandomNumberDomain;
import com.queue.system.core.exception.BasicException;
import com.queue.system.core.service.GetRandomNumberService;
import com.queue.system.integration.client.ProviderClient;

import feign.FeignException;
import io.github.resilience4j.retry.annotation.Retry;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GetRandomNumberServiceImpl implements GetRandomNumberService {

	private final ProviderClient providerClient;
	private final MeterRegistry meterRegistry;
	
	@Override
	@Retry(name = "getRandomNumber", fallbackMethod = "getRandomNumberFallback")
	public RandomNumberDomain getRandomNumber(Long userId) {
		meterRegistry.counter("call.endpoint.random").increment();
		return providerClient.getGeneratedNumber().toDomain();
	}

	public RandomNumberDomain getRandomNumberFallback(Long userId, FeignException exception) {
		meterRegistry.counter("call.endpoint.random.with.error").increment();
		throw new BasicException(exception);
	}
}