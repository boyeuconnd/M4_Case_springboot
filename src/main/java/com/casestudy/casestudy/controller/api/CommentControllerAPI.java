package com.casestudy.casestudy.controller.api;


import com.casestudy.casestudy.models.Users;
import com.casestudy.casestudy.models.blogs.Comment;
import com.casestudy.casestudy.models.blogs.Post;
import com.casestudy.casestudy.service.UserService;
import com.casestudy.casestudy.service.blogs.CommentService;
import com.casestudy.casestudy.service.blogs.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/comment")
public class CommentControllerAPI {

    @Autowired
    private CommentService commentService;

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public List<Comment> getAllComment(@PathVariable Long id){
        Post post= postService.findById(id);
        List<Comment> comments = commentService.findAllByPost(post);
        return comments;
    }


    @PostMapping("/{id}")
    public void saveComment(@PathVariable Long id , @RequestBody Comment comment, Principal principal) {
        Users currentUser = userService.findUsersByUserName(principal.getName());
        comment.setUsers(currentUser);
        Post post = postService.findById(id);
        comment.setPost(post);
        commentService.save(comment);
    }


}
