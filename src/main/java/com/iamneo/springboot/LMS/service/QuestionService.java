package com.iamneo.springboot.LMS.service;

import com.iamneo.springboot.LMS.dto.response.BulkResponse;
import com.iamneo.springboot.LMS.model.Question;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface QuestionService {

    Question createQuestion(Question question, long questionBankId);

    Question updateQuestion(long questionId, Question question);

    BulkResponse<List<Question>> bulkUpload(MultipartFile file, long questionBankId) throws IOException, Exception;

    Question getQuestionById(long Id) throws Exception;

}
