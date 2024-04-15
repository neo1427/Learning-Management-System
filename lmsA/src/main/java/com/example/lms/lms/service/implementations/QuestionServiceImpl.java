package com.example.lms.lms.service.implementations;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.lms.lms.dto.response.BulkResponse;
import com.example.lms.lms.model.Choice;
import com.example.lms.lms.model.Question;
import com.example.lms.lms.model.QuestionBank;
import com.example.lms.lms.repository.ChoiceRepository;
import com.example.lms.lms.repository.QuestionBankRepository;
import com.example.lms.lms.repository.QuestionRepository;
import com.example.lms.lms.service.QuestionService;
import com.example.lms.lms.utils.ServiceUtil;

import lombok.RequiredArgsConstructor;

import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private static final Logger logger = LoggerFactory.getLogger(QuestionServiceImpl.class);

    private final QuestionRepository questionRepository;
    private final QuestionBankRepository questionBankRepository;
    private final ServiceUtil serviceUtil;
    private final ChoiceRepository choiceRepository;

    public Question createQuestion(Question question, long questionBankId) {
        try {
            Question createdQuestion = questionRepository.save(question);
            createdQuestion.setQuestionBank(question.getQuestionBank());
            QuestionBank questionBank = questionBankRepository.findById(questionBankId).orElseThrow(() -> new Exception("Question Bank not found"));
            questionBank.getQuestions().add(createdQuestion);
            questionBankRepository.save(questionBank);
            return createdQuestion;
        } catch (Exception e) {
            logger.error("An unexpected error occurred while creating the question: " + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    public Question updateQuestion(long id, Question question) {
        try {
            // Add any business logic or validation here
            question.setQuestionId(id);
            Question updatedQuestion = questionRepository.save(question);

            List<Choice> choices = question.getOptions().stream()
                    .peek(choice -> choice.setQuestion(updatedQuestion))
                    .collect(Collectors.toList());

            choiceRepository.saveAll(choices);

            return updatedQuestion;
        } catch (Exception e) {
            logger.error("An unexpected error occurred while updating the question: " + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public Question getQuestionById(long id) {
        return questionRepository.findById(id).orElse(null);
    }

    public void deleteQuestion(long id) {
        questionRepository.deleteById(id);
    }

    @Override
    public BulkResponse<List<Question>> bulkUpload(MultipartFile file, long questionBankId)
            throws Exception {
        BulkResponse<List<Question>> questionsWithError = serviceUtil
                .parseCsvData(new String(file.getBytes()), questionBankId);
        List<Question> questions = questionRepository.saveAll(questionsWithError.getData());
        try {
            QuestionBank questionBank = questionBankRepository.findById(questionBankId).orElseThrow(() -> new Exception("Question Bank not found"));
            questions.stream().forEach(question -> question.setQuestionBank(questionBank));
            questionBank.getQuestions().addAll(questions);
            questionBankRepository.save(questionBank);
            questionsWithError.setData(questions);
            return questionsWithError;
   
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
