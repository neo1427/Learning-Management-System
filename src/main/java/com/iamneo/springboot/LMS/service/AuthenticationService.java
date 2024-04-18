package com.iamneo.springboot.LMS.service;

import com.iamneo.springboot.LMS.dto.request.LoginRequest;
import com.iamneo.springboot.LMS.dto.response.BasicResponse;
import com.iamneo.springboot.LMS.dto.response.LoginResponse;

public interface AuthenticationService {

    BasicResponse<LoginResponse> login(LoginRequest loginRequest);

}
