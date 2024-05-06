package com.iamneo.springboot.LMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iamneo.springboot.LMS.model.AcademicInfo;

@Repository
public interface AcademicInfoRepository extends JpaRepository<AcademicInfo, Long> {

}
