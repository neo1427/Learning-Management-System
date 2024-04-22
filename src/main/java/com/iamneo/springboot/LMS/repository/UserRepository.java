package com.iamneo.springboot.LMS.repository;

import com.iamneo.springboot.LMS.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserId(String userId);

}
