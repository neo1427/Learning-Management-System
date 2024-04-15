package com.example.lms.lms.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.lms.lms.dto.request.ChoiceRequest;
import com.example.lms.lms.dto.request.QuestionBankRequest;
import com.example.lms.lms.dto.request.QuestionRequest;
import com.example.lms.lms.dto.response.BulkResponse;
import com.example.lms.lms.model.Choice;
import com.example.lms.lms.model.Question;
import com.example.lms.lms.model.QuestionBank;
import com.example.lms.lms.service.QuestionBankService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServiceUtil {

    private final QuestionBankService questionBankService;

    // covert the file string to question
    public BulkResponse<List<Question>> parseCsvData(String csvData, long questionBankId) {
        List<Question> data = new ArrayList<>();

        String[] lines = csvData.split("\\r?\\n");
        Map<Integer, String> errors = new HashMap<>();
        // boolean optionsCorrect = true;

        for (int ind = 1; ind < lines.length; ind++) {
            String[] values = lines[ind].split(",");
            if (values.length < 6) {
                errors.put(Integer.parseInt(values[0]), "Please check the number of options");
                continue;
            }
            try {
                List<ChoiceRequest> choises = new ArrayList<>();
                for (int ctr = 2; ctr < values.length; ctr += 2) {
                    if (!values[ctr + 1].toLowerCase().equals("true")
                            && !values[ctr + 1].toLowerCase().equals("false")) {
                        throw new Exception("The Option should be either true or false");
                    }
                    choises.add(
                            ChoiceRequest.builder()
                                    .optionBody(values[ctr])
                                    .isCorrect(
                                            Boolean.parseBoolean(values[ctr + 1].toLowerCase()))
                                    .build());
                }

                QuestionRequest questionRequest = QuestionRequest
                        .builder()
                        .question(values[1])
                        .options(choises)
                        .build();
                data.add(mapRequestToEntity(questionRequest, questionBankId));

            } catch (Exception e) {
                errors.put(Integer.parseInt(values[0]), e.getMessage());
                continue;
            }
        }

        return BulkResponse.<List<Question>>builder().data(data).errors(errors).build();
    }

    public QuestionBank mapRequestToEntity(QuestionBankRequest questionBankRequest) {
        return QuestionBank.builder()
                .name(questionBankRequest.getName())
                .teacherId(questionBankRequest.getTeacherId())
                .tags(questionBankRequest.getTags())
                .build();
    }

    public Question mapRequestToEntity(QuestionRequest questionRequest, long questionBankId) throws Exception {
        Question question = new Question();
        question.setQuestion(questionRequest.getQuestion());
        question.setQuestionBank(questionBankService.findById(questionBankId));

        List<ChoiceRequest> choiceRequests = questionRequest.getOptions();
        List<Choice> choices = choiceRequests.stream()
                .map(this::mapChoiceRequestToEntity)
                .collect(Collectors.toList());

        question.setOptions(choices);
        return question;
    }

    public Choice mapChoiceRequestToEntity(ChoiceRequest choiceRequest) {
        Choice choice = new Choice();
        choice.setOptionBody(choiceRequest.getOptionBody());
        choice.setCorrect(choiceRequest.isCorrect());
        return choice;
    }

}
