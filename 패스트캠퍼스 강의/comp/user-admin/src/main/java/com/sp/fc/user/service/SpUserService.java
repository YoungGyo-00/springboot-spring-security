package com.sp.fc.user.service;

import com.sp.fc.user.repository.SpUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SpUserService implements UserDetailsService {

    private final SpUserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findSpUserByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
