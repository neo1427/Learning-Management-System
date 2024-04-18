package com.iamneo.springboot.LMS.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.iamneo.springboot.LMS.enumerated.Role;
import com.iamneo.springboot.LMS.model.User;
import com.iamneo.springboot.LMS.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserCli implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if(userRepository.count() > 0) return;

        var admin = User.builder()
                        .name("Admin")
                        .userId("admin")
                        .password(passwordEncoder.encode("Admin@123"))
                        .role(Role.ADMIN)
                        .build();
        userRepository.save(admin);
    }

    
}
