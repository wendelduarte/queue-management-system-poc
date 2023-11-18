package com.queue.system.integration.dto.response;

import com.queue.system.core.domain.RandomNumberDomain;

public record GeneratedNumberResponseDTO(
		int number, 
		boolean generated
) implements ResponseDTO{
	
	public RandomNumberDomain toDomain() {
		return new RandomNumberDomain(number, generated);
	}
}