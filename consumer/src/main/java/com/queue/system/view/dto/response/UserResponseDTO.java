package com.queue.system.view.dto.response;

public record UserResponseDTO(
		Long id,
		String name,
		Integer age
) implements ResponseDTO {
}