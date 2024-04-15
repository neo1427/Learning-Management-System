package com.example.lms.lms.service;

import java.util.List;

import com.example.lms.lms.model.QuestionBank;


public interface QuestionBankService {

    QuestionBank createQuestionBank(QuestionBank questionBank);

    List<QuestionBank> getAllQuestionBanks();

    QuestionBank findById(long questionBankId) throws Exception;

    public QuestionBank updateQuestionBank(long id, QuestionBank updatedQuestionBank);

}
