package com.queue.system.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;

@Configuration
public class MetricRegisterConfig {
	
	@Bean
	public MeterRegistry simpleMeterRegistry() {
		var meterRegistry = new SimpleMeterRegistry();
		meterRegistry.counter("call.endpoint.random");
		meterRegistry.counter("call.endpoint.random.with.error");
		return meterRegistry;
	}
}