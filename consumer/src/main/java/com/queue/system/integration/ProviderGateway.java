package com.queue.system.integration;

import org.springframework.stereotype.Component;

import com.queue.system.core.exception.IntegrationException;
import com.queue.system.integration.client.ProviderClient;
import com.queue.system.integration.dto.response.GeneratedNumberResponseDTO;

import feign.FeignException;
import io.github.resilience4j.retry.annotation.Retry;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProviderGateway {
	
	private final ProviderClient providerClient;
	private final MeterRegistry meterRegistry;

	@Retry(name = "getRandomNumber", fallbackMethod = "getRandomNumberFallback")
	public GeneratedNumberResponseDTO getRandomNumber() {
		meterRegistry.counter("call.endpoint.random").increment();
		return providerClient.getGeneratedNumber();
	}

	public GeneratedNumberResponseDTO getRandomNumberFallback(FeignException exception) {
		meterRegistry.counter("call.endpoint.random.with.error").increment();
		throw new IntegrationException(exception);
	}
}