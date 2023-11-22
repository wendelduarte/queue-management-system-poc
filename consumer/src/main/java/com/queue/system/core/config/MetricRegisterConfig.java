package com.queue.system.core.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;

@Configuration
public class MetricRegisterConfig {

	@Bean
	@Qualifier("allCallsToEndpointRandom")
	public Counter counterForEndpointRandom() {
		return new SimpleMeterRegistry().counter("call.endpoint.random");
	}
	
	@Bean
	@Qualifier("callsWithErrorToEndpointRandom")
	public Counter counterForEndpointRandomFail() {
		return new SimpleMeterRegistry().counter("call.endpoint.random.with.error");
	}
}
