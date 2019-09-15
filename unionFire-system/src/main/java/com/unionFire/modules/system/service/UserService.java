package com.unionFire.modules.system.service;

import com.unionFire.modules.system.domain.User;
import org.springframework.cache.annotation.Cacheable;

public interface UserService {

    /**
     * findByName
     * @param userName
     * @return
     */
    User findByName(String userName);

}
