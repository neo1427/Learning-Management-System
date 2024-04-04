package com.iamneo.springboot.LMS.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iamneo.springboot.LMS.exceptions.NotFoundException;
import com.iamneo.springboot.LMS.model.Question;
import com.iamneo.springboot.LMS.service.QuestionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/quiz/question")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @PostMapping("/addQuestion/{questionBankId}")
    public ResponseEntity<?> addQuestion(@RequestBody Question question, @PathVariable long questionBankId) {
        try {
            return new ResponseEntity<>(questionService.addQuestion(question, questionBankId), HttpStatus.CREATED);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllQuestions/{questionBankId}")
    public ResponseEntity<?> getAllQuestionByQuestionBankId(@PathVariable long questionBankId) {
        try {
            return new ResponseEntity<>(questionService.getAllQuestions(questionBankId), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
    }

    @PutMapping("/updateQuestion/{questionId}")
    public ResponseEntity<?> updateQuestion(@PathVariable long questionId, @RequestBody Question question) {
        try {
            return new ResponseEntity<>(questionService.updateQuestion(question, questionId), HttpStatus.ACCEPTED);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
