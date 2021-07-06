package com.spring.blog.service.serviceImpl;

import com.spring.blog.model.Commentary;
import com.spring.blog.model.Post;
import com.spring.blog.repository.BlogRepository;
import com.spring.blog.repository.CommentaryRepository;
import com.spring.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogRepository blogRepository;



    @Override
    public List<Post> findAllPost() {
        return blogRepository.findAll(sortByIdAsc());
    }

    @Override
    public Post findPostById(long id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public Post savePost(Post post) {
        return blogRepository.save(post);
    }
    @Override
    public void deletePost (long id){
        blogRepository.deleteById(id);
    }
    private Sort sortByIdAsc() {
        return new Sort(Sort.Direction.DESC, "id");
    }


}
