package com.example.myspringbootprojectsession13.security;

import com.example.myspringbootprojectsession13.entities.User;
import com.example.myspringbootprojectsession13.repositories.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailServiceCustom implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailServiceCustom(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserPrincipal loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "Không tìm thấy người dùng: " + username));

        String role = user.getRole();
        String authority = role.startsWith("ROLE_") ? role : "ROLE_" + role;
        return new UserPrincipal(user,
                List.of(new SimpleGrantedAuthority(authority)));
    }
}
