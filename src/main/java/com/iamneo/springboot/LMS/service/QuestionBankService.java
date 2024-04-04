package com.iamneo.springboot.LMS.service;

import com.iamneo.springboot.LMS.exceptions.NotFoundException;
import com.iamneo.springboot.LMS.model.Question;
import com.iamneo.springboot.LMS.model.QuestionBank;
import com.iamneo.springboot.LMS.exceptions.ResourceNotFoundException;

import java.util.List;

public interface QuestionBankService {
    List<QuestionBank> getAllQuestionBanks();
    QuestionBank getQuestionBankById(long id) throws ResourceNotFoundException;
    QuestionBank createQuestionBank(QuestionBank questionBank);
    void deleteQuestionBank(long id) throws ResourceNotFoundException;

    void addQuestionsToQuestionBank(List<Question> questions, long questionBankId) throws NotFoundException;

}

