package com.iamneo.springboot.LMS.service;

import java.io.IOException;
import java.util.List;

import com.iamneo.springboot.LMS.exceptions.NotFoundException;
import org.springframework.web.multipart.MultipartFile;

import com.iamneo.springboot.LMS.dto.response.BulkResponse;
import com.iamneo.springboot.LMS.model.Question;

public interface QuestionService {

    Question createQuestion(Question question, long questionBankId);

    Question updateQuestion(long questionId, Question question);

    BulkResponse<List<Question>> bulkUpload(MultipartFile file, long questionBankId) throws IOException, Exception;

    Question addQuestion(Question question, long questionBankId) throws NotFoundException,Exception;

    List<Question> getAllQuestions(long questionBankId) throws NotFoundException,Exception;

    Question updateQuestion(Question question, long questionId) throws NotFoundException, Exception;
}
