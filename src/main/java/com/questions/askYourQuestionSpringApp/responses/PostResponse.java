package com.questions.askYourQuestionSpringApp.responses;

import java.util.Date;
import java.util.List;

import com.questions.askYourQuestionSpringApp.entities.Post;

import lombok.Data;

@Data
public class PostResponse {

    Long id;
    Long userId;
    String userName;
    String title;
    String text;
    Date createDate;
    List<LikeResponse> postLikes;

    public PostResponse(Post post, List<LikeResponse> likes) {
        this.id = post.getId();
        this.userId = post.getUser().getId();
        this.userName = post.getUser().getUserName();
        this.title = post.getTitle();
        this.text = post.getText();
        this.createDate = post.getCreateDate();
        this.postLikes = likes;
    }
}
