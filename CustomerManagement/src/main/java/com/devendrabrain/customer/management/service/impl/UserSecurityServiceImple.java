package com.devendrabrain.customer.management.service.impl;

import com.devendrabrain.customer.management.entity.CustomUserDetails;
import com.devendrabrain.customer.management.entity.UserAuth;
import com.devendrabrain.customer.management.repository.UserSecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserSecurityServiceImple implements UserDetailsService {

    @Autowired
    UserSecurityRepository userSecurityRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserAuth userAuth = userSecurityRepository.findByUsername(username);

        if(userAuth == null) {
            new UsernameNotFoundException("User details does not exist with given detaild.. Username :"+username);
        }

        return new CustomUserDetails(userAuth.getUsername(),userAuth.getPassword(),true,userAuth.getAuthority());
    }
}
