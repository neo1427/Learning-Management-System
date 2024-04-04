package com.iamneo.springboot.LMS.controller;

import com.iamneo.springboot.LMS.model.Question;
import com.iamneo.springboot.LMS.model.QuestionBank;
import com.iamneo.springboot.LMS.service.QuestionBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/questionbanks")
public class QuestionBankController {

    @Autowired
    private QuestionBankService questionBankService;

    @GetMapping
    public List<QuestionBank> getAllQuestionBanks() {
        return questionBankService.getAllQuestionBanks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionBank> getQuestionBankById(@PathVariable(value = "id") long id) {
        QuestionBank questionBank = questionBankService.getQuestionBankById(id);
        return ResponseEntity.ok().body(questionBank);
    }

    @PostMapping
    public ResponseEntity<QuestionBank> createQuestionBank(@Valid @RequestBody QuestionBank questionBank) {
        QuestionBank createdQuestionBank = questionBankService.createQuestionBank(questionBank);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdQuestionBank);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteQuestionBank(@PathVariable(value = "id") long id) {
        questionBankService.deleteQuestionBank(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/questionbanks/{questionBankId}/questions")
    public ResponseEntity<?> addQuestionsToQuestionBank(@RequestBody List<Question> questions, @PathVariable long questionBankId) {
        try {
            questionBankService.addQuestionsToQuestionBank(questions, questionBankId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while adding questions to the question bank.");
        }
    }
}

