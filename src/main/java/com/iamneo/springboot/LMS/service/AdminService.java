package com.iamneo.springboot.LMS.service;

import com.iamneo.springboot.LMS.dto.request.RegisterRequest;
import com.iamneo.springboot.LMS.dto.response.BasicResponse;
import com.iamneo.springboot.LMS.enumerated.Role;
import com.iamneo.springboot.LMS.model.User;

import java.util.List;


public interface AdminService {

    BasicResponse<String> register(RegisterRequest registerRequest, Role role) throws Exception;

    List<User> findAll();
    
}
