package com.casestudy.casestudy.service.blogs;

import com.casestudy.casestudy.models.blogs.Comment;
import com.casestudy.casestudy.models.blogs.Post;
import org.springframework.stereotype.Service;


public interface CommentService {


    Iterable<Comment> findAll();

    Comment findById(Long id);

    Comment save(Comment comment);

    void delete(Long id);

    Iterable<Comment> findAllByPost(Post post);
}
