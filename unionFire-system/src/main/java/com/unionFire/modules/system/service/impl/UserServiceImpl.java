package com.unionFire.modules.system.service.impl;

import com.unionFire.exception.EntityNotFoundException;
import com.unionFire.modules.system.domain.User;
import com.unionFire.modules.system.resposity.UserRepository;
import com.unionFire.modules.system.service.UserService;
import com.unionFire.utils.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByName(String userName) {
        User user = null;
        if(ValidationUtil.isEmail(userName)){
            user = userRepository.findByEmail(userName);
        } else {
            user = userRepository.findByUsername(userName);
        }
        if (user == null) {
            throw new EntityNotFoundException(User.class, "name", userName);
        } else {
            return user;
        }
    }
}
