package com.unionFire.modules.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true,rollbackFor = Exception.class)
public class JwtUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username){
        return null;
    }


}
