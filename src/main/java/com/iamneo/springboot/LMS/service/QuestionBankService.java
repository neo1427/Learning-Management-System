package com.iamneo.springboot.LMS.service;

import com.iamneo.springboot.LMS.model.QuestionBank;

import java.util.List;

public interface QuestionBankService {

    QuestionBank createQuestionBank(QuestionBank questionBank);

    List<QuestionBank> getAllQuestionBanks();

    QuestionBank findById(long questionBankId) throws Exception;

    public QuestionBank updateQuestionBank(long id, QuestionBank updatedQuestionBank);

}
