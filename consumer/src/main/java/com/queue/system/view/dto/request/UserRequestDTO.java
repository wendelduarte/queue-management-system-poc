package com.queue.system.view.dto.request;

public record UserRequestDTO(
		String name,
		Integer age
) implements RequestDTO{

}