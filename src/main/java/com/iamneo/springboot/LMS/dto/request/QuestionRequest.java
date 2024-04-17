package com.iamneo.springboot.LMS.dto.request;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionRequest {
    @NotBlank(message = "Question cannot be empty")
    private String question;

    @Size(min = 2, message = "There should be atleast 2 options")
    private List<ChoiceRequest> options;
}
