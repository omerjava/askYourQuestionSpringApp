package com.questions.askYourQuestionSpringApp.responses;

import com.questions.askYourQuestionSpringApp.entities.Comment;

import lombok.Data;

import java.util.Date;

@Data
public class CommentResponse {

    Long id;
    Long userId;
    Long postId;
    String userName;
    String text;
    Date createDate;

    public CommentResponse(Comment comment) {
        this.id = comment.getId();
        this.userId = comment.getUser().getId();
        this.postId = comment.getPost().getId();
        this.userName = comment.getUser().getUserName();
        this.text = comment.getText();
        this.createDate = comment.getCreateDate();
    }
}
