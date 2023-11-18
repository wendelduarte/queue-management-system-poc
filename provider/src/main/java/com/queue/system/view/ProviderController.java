package com.queue.system.view;

import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provider")
public class ProviderController {

	@GetMapping
	public ResponseEntity<NumberGenerated> getNumber() {
		Random random = new Random();
		
		int range = 31;
		
		int generatedNumber = random.nextInt(range);
		
		var numberGenerated = new NumberGenerated(generatedNumber, true);
		
		if(generatedNumber < 10) {
			return ResponseEntity.ok(numberGenerated);
		} else if (generatedNumber >= 10 && generatedNumber < 20) {
			return new ResponseEntity<NumberGenerated>(numberGenerated, HttpStatus.TOO_MANY_REQUESTS);
		} else {
			return new ResponseEntity<NumberGenerated>(numberGenerated, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}