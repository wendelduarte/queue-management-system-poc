package com.queue.system.core.service.impl;

import org.springframework.stereotype.Service;

import com.queue.system.core.domain.RandomNumberDomain;
import com.queue.system.core.exception.TooManyRequestsException;
import com.queue.system.core.service.GetMetricsService;
import com.queue.system.core.service.GetRandomNumberService;
import com.queue.system.integration.ProviderGateway;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class GetRandomNumberServiceImpl implements GetRandomNumberService {

	private final ProviderGateway providerGateway;
	private final GetMetricsService getMetricsService;   
	private final MeterRegistry meterRegistry;
	
	@Override
	public RandomNumberDomain getRandomNumber(Long userId) {
		var metrics = getMetricsService.execute();
		if(metrics.percentageOfErrors() > 5.0 ) {
			meterRegistry.counter("call.endpoint.random").increment();
			log.warn("To many request, try again later");
			throw new TooManyRequestsException("Too many requests, user added to the queue.");
		}
		return providerGateway.getRandomNumber().toDomain();
	}
}