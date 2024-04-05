package com.iamneo.springboot.LMS.service.implementation;

import com.iamneo.springboot.LMS.exceptions.NotFoundException;
import com.iamneo.springboot.LMS.model.Question;
import com.iamneo.springboot.LMS.model.QuestionBank;
import com.iamneo.springboot.LMS.exceptions.ResourceNotFoundException;
import com.iamneo.springboot.LMS.repository.QuestionBankRepository;
import com.iamneo.springboot.LMS.service.QuestionBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionBankServiceImpl implements QuestionBankService {

    @Autowired
    private QuestionBankRepository questionBankRepository;

    @Override
    public List<QuestionBank> getAllQuestionBanks() {
        return questionBankRepository.findAll();
    }

    @Override
    public QuestionBank getQuestionBankById(long id) throws ResourceNotFoundException {
        return questionBankRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("QuestionBank", "id", id));
    }

    @Override
    public QuestionBank createQuestionBank(QuestionBank questionBank) {
        return questionBankRepository.save(questionBank);
    }

    @Override
    public void deleteQuestionBank(long id) throws ResourceNotFoundException {
        if (!questionBankRepository.existsById(id)) {
            throw new ResourceNotFoundException("QuestionBank", "id", id);
        }
        questionBankRepository.deleteById(id);
    }

    public void addQuestionsToQuestionBank(List<Question> questions, long questionBankId) throws NotFoundException {
        QuestionBank questionBank = questionBankRepository.findById(questionBankId)
                .orElseThrow(() -> new NotFoundException("Question Bank not found with id: " + questionBankId));
        questionBank.getQuestions().addAll(questions);
        questionBankRepository.save(questionBank);
    }
}

