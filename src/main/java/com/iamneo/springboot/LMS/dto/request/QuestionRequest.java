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
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionRequest {
    @NotBlank(message = "Question cannot be empty")
    @Schema(name = "Q1", description = "The question you want to create", example = "What is the capital of France?")
    private String question;

    @Size(min = 2, message = "There should be at least 2 options")
    @Schema(name = "Options", description = "The list of options for the question")
    private List<ChoiceRequest> options;
}
