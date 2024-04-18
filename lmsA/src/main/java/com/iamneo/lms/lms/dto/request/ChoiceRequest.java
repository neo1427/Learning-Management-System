package com.iamneo.lms.lms.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChoiceRequest {
    
    @NotBlank(message = "Please provide an option")
    private String optionBody;

    @NotNull(message = "Provide this option is correct or not")
    private boolean isCorrect;
}
