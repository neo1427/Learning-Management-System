/*
All the required validations for all the fields should be there
    1. name should be checked that it is not empty and not blank and not null.
    2. questions doesn't need any validation.
    3. teacherId should be checked that it is not empty and not blank and not null.
    4. tags doesn't need any validation.
*/

package com.iamneo.springboot.LMS.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionBank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long questionBankId;

    private String name;

    // @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id_question_bank", referencedColumnName = "questionBankId")
    private List<Question> questions;

    private String teacherId;
    private List<String> tags;
}