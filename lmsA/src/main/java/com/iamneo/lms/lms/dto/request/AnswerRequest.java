package com.iamneo.lms.lms.dto.request;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnswerRequest {

    @NotBlank(message = "Question ID is mandatory field")
    private long questionId;

    @NotBlank(message = "Student ID is a mandatory field")
    private String studentId;

    @NotBlank(message = "Test ID is a mandatory field")
    private long testId;

    @Size(min = 1, max = 4, message = "plese provide correct options of what the students have selected")
    private List<Long> answers;
}
