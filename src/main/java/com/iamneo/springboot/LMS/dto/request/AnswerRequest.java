package com.iamneo.springboot.LMS.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnswerRequest {

    @NotBlank(message = "Question ID is a mandatory field")
    @Schema(name = "Question ID", example = "12345", description = "The unique identifier of the question")
    private long questionId;

    @NotBlank(message = "Student ID is a mandatory field")
    @Schema(name = "Student ID", example = "S123", description = "The unique identifier of the student")
    private String studentId;

    @NotBlank(message = "Test ID is a mandatory field")
    @Schema(name = "Test ID", example = "54321", description = "The unique identifier of the test")
    private long testId;

    @Size(min = 1, max = 4, message = "Please provide correct options of what the students have selected")
    @Schema(name = "Answers", description = "List of selected options by the student")
    private List<Long> answers;
}
