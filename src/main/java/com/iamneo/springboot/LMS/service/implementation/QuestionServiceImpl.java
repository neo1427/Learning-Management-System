package com.iamneo.springboot.LMS.service.implementation;

import java.util.Optional;
import java.util.List;

import com.iamneo.springboot.LMS.exceptions.NotFoundException;
import com.iamneo.springboot.LMS.model.Question;
import com.iamneo.springboot.LMS.model.QuestionBank;
import com.iamneo.springboot.LMS.repository.QuestionBankRepository;
import com.iamneo.springboot.LMS.repository.QuestionRepository;
import com.iamneo.springboot.LMS.service.QuestionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public abstract class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final QuestionBankRepository questionBankRepository;
    
    private QuestionBank getQuestionBank(long questionBankId) throws NotFoundException {
        Optional<QuestionBank> questionBank = questionBankRepository.findById(questionBankId);
        if(questionBank.isEmpty()) throw new NotFoundException("The question bank does not exists");
        return questionBank.get();
    }

    @Override
    public Question addQuestion(Question question, long questionBankId) throws NotFoundException,Exception {
        QuestionBank questionBank = getQuestionBank(questionBankId);
        question.setQuestionBank(questionBank);
        questionBank.getQuestions().add(question);
        questionBankRepository.save(questionBank);
        question = questionRepository.save(question);
        return question;
    }

    @Override
    public List<Question> getAllQuestions(long questionBankId) throws NotFoundException,Exception {
        return getQuestionBank(questionBankId).getQuestions();
        
    }


    @Override
    public Question updateQuestion(Question question, long questionId) throws NotFoundException, Exception {
        Optional<Question> questionOpt = questionRepository.findById(questionId);
        if(questionOpt.isEmpty()) throw new NotFoundException("Question you are trying to update does not exists");
        if(question.getId() != questionId) throw new Exception("Ids are not equal");
        QuestionBank questionBank = questionOpt.get().getQuestionBank();
        questionBank.getQuestions().remove(questionOpt.get());
        question.setQuestionBank(questionBank);
        question = questionRepository.save(question);
        questionBank.getQuestions().add(question);
        questionBankRepository.save(questionBank);
        return question;
    }

}
