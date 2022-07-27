package com.questions.askYourQuestionSpringApp.services;


import java.time.Instant;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.questions.askYourQuestionSpringApp.entities.RefreshToken;
import com.questions.askYourQuestionSpringApp.entities.User;
import com.questions.askYourQuestionSpringApp.repos.RefreshTokenRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class RefreshTokenService {

    @Value("${refresh.token.expires.in}")
    Long expireSeconds;

    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshTokenService(RefreshTokenRepository refreshTokenRepository) {
        this.refreshTokenRepository = refreshTokenRepository;
    }

    public String createRefreshToken(User user) {
        RefreshToken token = refreshTokenRepository.findByUserId(user.getId());
        if(token == null) {
            token =	new RefreshToken();
            token.setUser(user);
        }
        token.setToken(UUID.randomUUID().toString());
        token.setExpiryDate(Date.from(Instant.now().plusSeconds(expireSeconds)));
        refreshTokenRepository.save(token);
        return token.getToken();
    }

    public boolean isRefreshExpired(RefreshToken token) {
        return token.getExpiryDate().before(new Date());
    }

    public RefreshToken getByUser(Long userId) {
        return refreshTokenRepository.findByUserId(userId);
    }

    public void deleteByUserId(Long userId) {refreshTokenRepository.deleteByUserId(userId);}
}
