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
import lombok.Data;

@Entity
@Data
public class TestResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private Test test;

    private List<String> studentIds;
    private List<Integer> marks;
}
