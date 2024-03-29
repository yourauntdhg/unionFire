package com.unionFire.modules.security.service;

import com.unionFire.modules.system.domain.*;
import com.unionFire.modules.system.resposity.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class JwtPermissionService {
    @Autowired
    private RoleRepository roleRepository;

    /**
     * key的名称如有修改，请同步修改 UserServiceImpl 中的 update 方法
     * @param user
     * @return
     */
    public Collection<GrantedAuthority> mapToGrantedAuthorities(User user) {

        System.out.println("--------------------loadPermissionByUser:" + user.getUsername() + "---------------------");

        Set<Role> roles = roleRepository.findByUsers_Id(user.getId());

        return roles.stream().flatMap(role -> role.getPermissions().stream())
                .map(permission -> new SimpleGrantedAuthority(permission.getName()))
                .collect(Collectors.toList());
    }
}
