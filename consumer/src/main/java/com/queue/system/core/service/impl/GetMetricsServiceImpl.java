package com.queue.system.core.service.impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.queue.system.core.domain.ServiceMetricsDomain;
import com.queue.system.core.service.GetMetricsService;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.search.MeterNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GetMetricsServiceImpl implements GetMetricsService {
	
	private static final double NO_METRICS = 0;
	private static final int ONE_MINUTE_IN_SECONDS = 60;
	

	private final MeterRegistry meterRegistry;

	@Override
	public ServiceMetricsDomain execute() {
		try {
			var allCalls = meterRegistry.get("call.endpoint.random").counter().count();
			var errorsCalls = meterRegistry.get("call.endpoint.random.with.error").counter().count();
			double percentageOfErrors = (errorsCalls / allCalls) * 100;
			double callsPerSecond = allCalls / LocalDateTime.now().getSecond();
			
			return new ServiceMetricsDomain(allCalls, errorsCalls, percentageOfErrors, callsPerSecond);	
		} catch (MeterNotFoundException exception) {
			return new ServiceMetricsDomain(NO_METRICS, NO_METRICS, NO_METRICS, NO_METRICS);
		}
	}
}