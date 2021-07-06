package com.spring.blog.service.serviceImpl;

import com.spring.blog.model.Commentary;
import com.spring.blog.model.Post;
import com.spring.blog.repository.CommentaryRepository;
import com.spring.blog.service.CommentaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentaryServiceImpl implements CommentaryService{

    @Autowired
    CommentaryRepository commentaryRepository;

    @Override
    public List<Commentary> findAllCommentary() {
        return commentaryRepository.findAll(sortByIdAsc());
    }

    @Override
    public Commentary findCommentaryById(long id) {
        return commentaryRepository.findById(id).get();
    }


    @Override
    public Commentary saveCommentary(long id, Commentary commentary) {
        return commentaryRepository.save(commentary);
    }
    @Override
    public void deleteCommentary (long id){
        commentaryRepository.deleteById(id);
    }
    private Sort sortByIdAsc() {
        return new Sort(Sort.Direction.DESC, "id");
    }
}
