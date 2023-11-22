package com.queue.system.view.dto.response;

public record MetricsResponseDTO(double allCalls, double callsWithError, double percentageOfSuccess) implements ResponseDTO{

}
