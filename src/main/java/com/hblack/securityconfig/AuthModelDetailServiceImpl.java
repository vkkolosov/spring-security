package com.hblack.securityconfig;

import com.hblack.model.DefaultAuthModel;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AuthModelDetailServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        DefaultAuthModel defaultAuthModel = new DefaultAuthModel(); //firebase find by user
        defaultAuthModel.setUserName(username);
        AuthModelDetailsImpl authModelDetails = new AuthModelDetailsImpl(defaultAuthModel);
        return authModelDetails;
    }

}
