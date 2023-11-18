package com.queue.system.core.domain;

import com.queue.system.view.dto.response.UserResponseDTO;

import lombok.Builder;

@Builder
public record UserDomain(
		Long id,
		String name,
		Integer age
) {

	public UserResponseDTO toUserResponseDTO() {
		return new UserResponseDTO(id, name, age);
	}
}
