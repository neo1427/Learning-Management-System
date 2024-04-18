package com.iamneo.springboot.LMS.service.implementations;

import com.iamneo.springboot.LMS.dto.request.RegisterRequest;
import com.iamneo.springboot.LMS.dto.response.BasicResponse;
import com.iamneo.springboot.LMS.enumerated.Role;
import com.iamneo.springboot.LMS.model.User;
import com.iamneo.springboot.LMS.repository.UserRepository;
import com.iamneo.springboot.LMS.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Override
    public BasicResponse<String> register(RegisterRequest registerRequest, Role role) throws Exception {
        Optional<User> userOps = userRepository.findByUserId(registerRequest.getUserId());
        if(userOps.isPresent()) throw new Exception(registerRequest.getUserId() + " Already Exists");
        var user = User.builder()
                    .name(registerRequest.getName())
                    .userId(registerRequest.getUserId())
                    .password(passwordEncoder.encode(registerRequest.getPassword()))
                    .role(role)
                    .build();

        userRepository.save(user);

        return BasicResponse.<String>builder().message("User Registered successfully").data("").build();
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll().stream().toList();
    }

}
