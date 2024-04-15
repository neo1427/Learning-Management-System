package com.example.lms.lms.dto.request;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionBankRequest {
    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Teacher ID is required")
    private String teacherId;
    
    private List<String> tags;
}
