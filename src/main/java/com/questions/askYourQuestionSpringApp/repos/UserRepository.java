package com.questions.askYourQuestionSpringApp.repos;

import com.questions.askYourQuestionSpringApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long> {
        User findByUserName(String userName);
}
