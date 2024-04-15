package com.example.lms.lms.service;

import java.util.List;

import com.example.lms.lms.dto.request.RegisterRequest;
import com.example.lms.lms.dto.response.BasicResponse;
import com.example.lms.lms.enumerated.Role;
import com.example.lms.lms.model.User;


public interface AdminService {

    BasicResponse<String> register(RegisterRequest registerRequest, Role role) throws Exception;

    List<User> findAll();
    
}
