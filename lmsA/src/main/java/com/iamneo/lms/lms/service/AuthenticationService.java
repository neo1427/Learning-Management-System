package com.iamneo.lms.lms.service;

import com.iamneo.lms.lms.dto.request.LoginRequest;
import com.iamneo.lms.lms.dto.response.BasicResponse;
import com.iamneo.lms.lms.dto.response.LoginResponse;

public interface AuthenticationService {

    BasicResponse<LoginResponse> login(LoginRequest loginRequest);

}
