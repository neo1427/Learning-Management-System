/*
All the required validations for all the fields should be there
    1. test should not be null.
    2. studentIds should be atleast of size 1.
    3. marks size should be equal to size of studentIds.
*/

package com.iamneo.springboot.LMS.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class TestResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "Test is required")
    @OneToOne
    private Test test;

    @NotEmpty(message = "At least one student ID is required")
    @Size(min = 1, message = "At least one student ID is required")
    private List<String> studentIds;

    @Valid
    private List<Integer> marks;
}
