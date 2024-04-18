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

    @NotBlank(message = "Question ID is a mandatory field")
    @Schema(name = "Question ID", example = "12345", description = "The unique identifier of the question, this will be given automatically from session storage in front end")
    private long questionId;

    @NotBlank(message = "Student ID is a mandatory field")
    @Schema(name = "Student ID", example = "S123", description = "The unique identifier of the student, this will be given automatically from session storage in front end")
    private String studentId;

    @NotBlank(message = "Test ID is a mandatory field")
    @Schema(name = "Test ID", example = "54321", description = "The unique identifier of the test, this will be given automatically from session storage in front end")
    private long testId;

    @Size(min = 1, max = 4, message = "Please provide correct options of what the students have selected")
    @Schema(name = "Answers", description = "List of selected options by the student", minItems = 1, maxItems = 4, this will be given automatically from session storage in front end)
    private List<Long> answers;
}
