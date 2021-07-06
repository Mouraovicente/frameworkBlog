package com.spring.blog.service;

import com.spring.blog.model.Post;

import java.util.List;

public interface BlogService {
    List<Post> findAllPost();
    Post findPostById(long id);
    Post savePost(Post post);
    void deletePost (long id);


}
