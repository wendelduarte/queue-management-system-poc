package com.queue.system.view.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.queue.system.view.dto.response.MetricsResponseDTO;

@RequestMapping("/metrics")
public interface MetricsController {

	@GetMapping
	MetricsResponseDTO getMetrics();
}
