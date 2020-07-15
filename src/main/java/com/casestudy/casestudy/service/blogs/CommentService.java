package com.casestudy.casestudy.service.blogs;

import com.casestudy.casestudy.models.blogs.Comment;
import com.casestudy.casestudy.models.blogs.Post;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CommentService {


    Iterable<Comment> findAll();

    Comment findById(Long id);

    Comment save(Comment comment);

    void delete(Long id);

    List<Comment> findAllByPost(Post post);
}
