package com.queue.system.integration.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.queue.system.integration.dto.response.GeneratedNumberResponseDTO;

import feign.Headers;

@FeignClient(name = "ProviderClient", url = "${poc.provider.url}")
@Headers({"Content-Type: application/json; charset=utf-8", "Accept: applictation/json; charset=utf-8"})
public interface ProviderClient {

	@GetMapping("/provider")
	GeneratedNumberResponseDTO getGeneratedNumber();
}
