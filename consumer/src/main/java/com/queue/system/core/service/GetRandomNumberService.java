package com.queue.system.core.service;

import com.queue.system.core.domain.RandomNumberDomain;

public interface GetRandomNumberService {
	
	RandomNumberDomain getRandomNumber(Long userId);

}
