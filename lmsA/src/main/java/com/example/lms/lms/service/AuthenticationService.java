package com.example.lms.lms.service;

import com.example.lms.lms.dto.request.LoginRequest;
import com.example.lms.lms.dto.response.BasicResponse;
import com.example.lms.lms.dto.response.LoginResponse;

public interface AuthenticationService {

    BasicResponse<LoginResponse> login(LoginRequest loginRequest);

}
