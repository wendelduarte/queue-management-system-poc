package com.queue.system.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class MeterResetConfig {

	private final MeterRegistry meterRegistry;
	
	@Scheduled(cron = "0 0/1 * 1/1 * ?")
	public void resetMetric() {
		System.out.println("Rodei o job");
		meterRegistry.clear();
		meterRegistry.counter("call.endpoint.random");
		meterRegistry.counter("call.endpoint.random.with.error");
	}
}