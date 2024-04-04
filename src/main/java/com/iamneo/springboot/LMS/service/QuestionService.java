package com.iamneo.springboot.LMS.service;

import org.springframework.stereotype.Service;

import com.iamneo.springboot.LMS.exceptions.NotFoundException;
import com.iamneo.springboot.LMS.model.Question;
import com.iamneo.springboot.LMS.model.QuestionBank;

@Service
public interface QuestionService {

    public Question addQuestion(Question question, long questionBankId) throws NotFoundException, Exception;

    public Object getAllQuestions(long questionBankId) throws NotFoundException, Exception;

    public Question updateQuestion(Question question, long questionId) throws NotFoundException, Exception;

    public QuestionBank addQuestion(String path, long questionBankId);
}
