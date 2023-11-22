package com.queue.system.view.controller.impl;

import org.springframework.web.bind.annotation.RestController;

import com.queue.system.core.service.GetMetricsService;
import com.queue.system.view.controller.MetricsController;
import com.queue.system.view.dto.response.MetricsResponseDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MetricsControllerImpl implements MetricsController{

	private final GetMetricsService getMetricsService;
	
	@Override
	public MetricsResponseDTO getMetrics() {
		var metrics = getMetricsService.execute();
		return new MetricsResponseDTO(metrics.totalCalls(), metrics.callWithError(), metrics.percentageOfSuccess());
	}

}
