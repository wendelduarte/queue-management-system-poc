package com.queue.system.core.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.queue.system.core.domain.ServiceMetricsDomain;
import com.queue.system.core.service.GetMetricsService;

import io.micrometer.core.instrument.Counter;

@Service
public class GetMetricsServiceImpl implements GetMetricsService {

	private final Counter allCallsToEndpointRandom;
	private final Counter callsWithErrorToEndpointRandom;
	
	public GetMetricsServiceImpl(@Qualifier("allCallsToEndpointRandom") Counter allCallsToEndpointRandom, 
			@Qualifier("callsWithErrorToEndpointRandom") Counter callsWithErrorToEndpointRandom) {
		this.allCallsToEndpointRandom = allCallsToEndpointRandom;
		this.callsWithErrorToEndpointRandom = callsWithErrorToEndpointRandom;
	}

	@Override
	public ServiceMetricsDomain execute() {
		var allCalls = allCallsToEndpointRandom.count();
		var errorsCalls = callsWithErrorToEndpointRandom.count();
		var percentageOfSuccess = (errorsCalls / allCalls) * 100;
		return new ServiceMetricsDomain(allCalls, errorsCalls, percentageOfSuccess);
	}
}