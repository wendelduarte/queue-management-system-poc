package com.queue.system.view.dto.response;

public record MetricsResponseDTO(double allCalls, double callsWithError, double percentageOfErrors, double callsPerSecond) implements ResponseDTO{

}
