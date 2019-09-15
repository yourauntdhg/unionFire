package com.unionFire.modules.system.resposity;

import com.unionFire.modules.system.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor {

    /**
     * findByEmail
     * @param email
     * @return
     */
    User findByEmail(String email);

    /**
     * findByUsername
     * @param username
     * @return
     */
    User findByUsername(String username);
}
