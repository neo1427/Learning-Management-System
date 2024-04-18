package com.iamneo.springboot.LMS.repository;

import com.iamneo.springboot.LMS.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {

    Optional<Token> findByToken(String token);

    List<Token> findAllByUser_IdAndRevokedFalseAndExpiredFalse(long id);

}
