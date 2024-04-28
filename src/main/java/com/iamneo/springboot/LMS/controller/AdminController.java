package com.iamneo.springboot.LMS.controller;

import com.iamneo.springboot.LMS.dto.request.RegisterRequest;
import com.iamneo.springboot.LMS.dto.response.BasicResponse;
import com.iamneo.springboot.LMS.enumerated.Role;
import com.iamneo.springboot.LMS.model.User;
import com.iamneo.springboot.LMS.service.AdminService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/lms/admin")
@RequiredArgsConstructor
@Validated
public class AdminController {

    private final AdminService adminService;

    @Operation(summary = "Registering a new student", description = "This is the api endpoint that helps to register a new student to the portal")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully Registered"),
            @ApiResponse(responseCode = "500", description = "Unexpected Error Occured")
    })


    @PostMapping("/register/student")
    public ResponseEntity<BasicResponse<String>> registerStudent(@Valid @RequestBody RegisterRequest registerRequest) {
        BasicResponse<String> response = new BasicResponse<>();
        try {
            response = adminService.register(registerRequest, Role.STUDENT);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            response.setMessage("Something went wrong");
            response.setData(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @Operation(summary = "Registering a new teacher", description = "This is the api endpoint that helps to register a new teacher to the portal")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully Registered"),
            @ApiResponse(responseCode = "500", description = "Unexpected Error Occured")
    })


    @PostMapping("/register/teacher")
    public ResponseEntity<BasicResponse<String>> registerTeacher(@Valid @RequestBody RegisterRequest registerRequest) {
        BasicResponse<String> response = new BasicResponse<>();
        try {
            response = adminService.register(registerRequest, Role.TEACHER);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            response.setMessage("Something went wrong");
            response.setData(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @Operation(summary = "Retrieving the details of all the users", description = "This is the api endpoint that helps to retrieve the details of all the users of the portal, such as teachers and students")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully Retrieved"),
            @ApiResponse(responseCode = "500", description = "Unexpected Error Occured")
    })


    @GetMapping("/getAll/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(adminService.findAll(), HttpStatus.OK);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException e) {
        Map<String, String> errorMap = new HashMap<>();

        e.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errorMap.put(fieldName, errorMessage);
        });

        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }
}


