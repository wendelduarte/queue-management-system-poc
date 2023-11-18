package com.queue.system.view;

import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
@RequestMapping("/provider")
public class ProviderController {

	@GetMapping
	@RateLimiter(name = "randomNumber", fallbackMethod = "getNumberFallback")
	public ResponseEntity<ResponseDTO> getNumber() {
		Random random = new Random();	
		var numberGenerated = new NumberGenerated(random.nextInt(), true);
		return ResponseEntity.ok(numberGenerated);
	}
	
	public ResponseEntity<ResponseDTO> getNumberFallback(RequestNotPermitted requestNotPermitted) {
		var message = new LimiterError("Too many calls to getNumber()");
		return new ResponseEntity<ResponseDTO>(message, HttpStatus.TOO_MANY_REQUESTS);
	}
}