package com.iamneo.springboot.LMS.Controller;

import com.iamneo.springboot.LMS.model.Test;
import com.iamneo.springboot.LMS.service.TestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tests")
public class TestUpdateController {

    private final TestService testService;

    @Autowired
    public TestUpdateController(TestService testUpdateService) {
        this.testService = testUpdateService;
    }

    @PutMapping("/{testId}")
    public ResponseEntity<?> updateTest(@PathVariable long testId, @RequestBody Test test) {
        
        try {
            test = testService.updateTest(testId, test);
            return new ResponseEntity<>(test, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        
        // return ResponseEntity.status(HttpStatus.OK).body("Test updated successfully");
    }
}
