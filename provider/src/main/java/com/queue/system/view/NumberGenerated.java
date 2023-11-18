package com.queue.system.view;

import lombok.Builder;

@Builder
public record NumberGenerated(
		Integer number,
		boolean generated) implements ResponseDTO{

}
