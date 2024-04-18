package com.iamneo.springboot.LMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iamneo.springboot.LMS.model.Choice;

public interface ChoiceRepository extends JpaRepository<Choice, Long> {

}
