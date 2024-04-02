package com.iamneo.springboot.LMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iamneo.springboot.LMS.model.TestResult;

@Repository
public interface TestResultRepository extends JpaRepository<TestResult, Long>{
    
}
