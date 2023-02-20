package com.multiplex.serviceimpl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.multiplex.dao.UsersRepository;
import com.multiplex.entity.UserSecurity;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class JpaUserDetailsService implements UserDetailsService {
    private final UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usersRepository.findByUsername(username).map(UserSecurity::new).orElseThrow(() -> new UsernameNotFoundException("User Not Found!"));
    }
}