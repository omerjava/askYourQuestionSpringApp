package com.questions.askYourQuestionSpringApp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.questions.askYourQuestionSpringApp.entities.RefreshToken;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long>{

    RefreshToken findByUserId(Long userId);

    void deleteByUserId(Long userId);
}
