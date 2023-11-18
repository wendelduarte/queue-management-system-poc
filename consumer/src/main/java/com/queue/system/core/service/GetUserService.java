package com.queue.system.core.service;

import com.queue.system.core.domain.UserDomain;

public interface GetUserService {

	UserDomain execute(Long userId);
}
