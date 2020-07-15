package com.casestudy.casestudy.controller.blogs;


import com.casestudy.casestudy.models.Users;
import com.casestudy.casestudy.models.blogs.Category;
import com.casestudy.casestudy.models.blogs.Comment;
import com.casestudy.casestudy.models.blogs.Post;
import com.casestudy.casestudy.service.UserService;
import com.casestudy.casestudy.service.blogs.CommentService;
import com.casestudy.casestudy.service.blogs.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class CommentController {

    @Autowired
    CommentService commentService;

    @Autowired
    UserService userService;

    @Autowired
    PostService postService;

    @PostMapping("/comment")
    public ModelAndView addComment(@ModelAttribute Comment comment, Principal principal){
        Users currentUser = userService.findUsersByUserName(principal.getName());
        comment.setUsers(currentUser);
        commentService.save(comment);
        ModelAndView modelAndView = new ModelAndView("/blogs/blog-detail");
        modelAndView.addObject("comment", new Comment());
        return modelAndView;
    }
}
