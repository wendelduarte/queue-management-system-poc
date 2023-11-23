package com.queue.system.core.domain;

public record ServiceMetricsDomain(double totalCalls, double callWithError, double percentageOfErrors, double callsPerSecond) {

}
