package com.iamneo.springboot.LMS.service;

import java.util.List;

import com.iamneo.springboot.LMS.model.QuestionBank;


public interface QuestionBankService {

    QuestionBank createQuestionBank(QuestionBank questionBank);

    List<QuestionBank> getAllQuestionBanks();

    QuestionBank findById(long questionBankId) throws Exception;

    public QuestionBank updateQuestionBank(long id, QuestionBank updatedQuestionBank);

}