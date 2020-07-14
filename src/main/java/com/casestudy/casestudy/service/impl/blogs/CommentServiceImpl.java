package com.casestudy.casestudy.service.impl.blogs;

import com.casestudy.casestudy.models.blogs.Comment;
import com.casestudy.casestudy.models.blogs.Post;
import com.casestudy.casestudy.repositories.blogs.CommentRepository;
import com.casestudy.casestudy.service.blogs.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;


    @Override
    public Iterable<Comment> findAll() {
        return null;
    }

    @Override
    public Comment findById(Long id) {
        return commentRepository.findById(id).get();
    }

    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public void delete(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public Iterable<Comment> findAllByPost(Post post) {
        return commentRepository.findCommentsByPost(post);
    }
}
