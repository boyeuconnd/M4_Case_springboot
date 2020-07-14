package com.casestudy.casestudy.controller.blogs;


import com.casestudy.casestudy.models.blogs.Comment;
import com.casestudy.casestudy.models.blogs.Post;
import com.casestudy.casestudy.service.blogs.CommentService;
import com.casestudy.casestudy.service.blogs.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.jws.Oneway;
import java.util.List;

@Controller
@RequestMapping("api/blog")
public class CommentControllerAPI {

    @Autowired
    private CommentService commentService;

    @Autowired
    private PostService postService;

    @GetMapping("/getAllComment/{id}")
    public Iterable<Comment> getAllComment(@PathVariable Long id){
        Iterable<Comment> list = commentService.findAllByPost(id);
        return list;
    }


    @PostMapping("/saveComment/{id}")
    public void saveComment(@PathVariable Long id ,@RequestBody Comment comment) {
       Post post = postService.findById(id);
        comment.setPost(post);
        commentService.save(comment);
    }


}
