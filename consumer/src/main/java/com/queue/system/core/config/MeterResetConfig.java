package com.queue.system.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class MeterResetConfig {

	private final MeterRegistry meterRegistry;
	
	@Scheduled(cron = "0 0/1 * 1/1 * ?")
	public void resetMetric() {
		log.info("Reseting metrics for random endpoint");
		meterRegistry.clear();
		meterRegistry.counter("call.endpoint.random");
		meterRegistry.counter("call.endpoint.random.with.error");
	}
}