package com.iamneo.springboot.LMS.dto.request;

import com.iamneo.springboot.LMS.enumerated.MarkType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AcademicInfoRequest {

    @NotBlank(message = "Please provide the institution name")
    private String institution;

    @NotBlank(message = "Please provide the degree name")
    private String degree;

    @NotBlank(message = "PLease provide the major")
    private String major;

    @NotBlank(message = "Please provide the marks obtained by the user")
    @Min(value = 1)
    private double marks;
    private MarkType markType;
}

