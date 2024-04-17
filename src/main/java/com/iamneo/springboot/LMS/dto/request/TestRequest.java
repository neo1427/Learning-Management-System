package com.iamneo.springboot.LMS.dto.request;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TestRequest {

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Course Id is mandatory")
    private String courseId;

    private LocalDate date;
    private LocalTime time;

    @Min(value = 1, message = "Please provide the buffer time for joining (should be atleast a minute)")
    private int bufferTime;

    @Min(value = 5, message = "Please provide a quiz duration (Should be greater than or equal to 5)")
    private int duration;
}
