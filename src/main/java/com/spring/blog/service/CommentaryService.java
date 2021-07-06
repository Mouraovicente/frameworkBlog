package com.spring.blog.service;

import com.spring.blog.model.Commentary;
import com.spring.blog.model.Post;

import java.util.List;

public interface CommentaryService {
    List<Commentary> findAllCommentary();
    Commentary findCommentaryById(long id);
    Commentary saveCommentary(long id, Commentary commentary);
    void deleteCommentary (long id);
}
