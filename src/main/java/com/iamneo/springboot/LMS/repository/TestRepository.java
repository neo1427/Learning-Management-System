package com.iamneo.springboot.LMS.repository;

import com.iamneo.springboot.LMS.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestRepository extends JpaRepository<Test, Long> {

    List<Test> findAllByCourseId(String courseId);

}
