package org.vit.springsecurityjpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.vit.springsecurityjpa.model.User;
import org.vit.springsecurityjpa.repository.UserRepository;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByUserName(userName);
        optionalUser.orElseThrow(() -> new UsernameNotFoundException("Invalid User Name: " + userName));
        return optionalUser.map(MyUserDetails::new).get();
    }

}
