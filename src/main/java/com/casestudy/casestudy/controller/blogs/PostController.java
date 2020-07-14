package com.casestudy.casestudy.controller.blogs;



import com.casestudy.casestudy.models.Users;
import com.casestudy.casestudy.models.blogs.Category;
import com.casestudy.casestudy.models.blogs.Comment;
import com.casestudy.casestudy.models.blogs.Post;
import com.casestudy.casestudy.service.UserService;
import com.casestudy.casestudy.service.blogs.CategoryService;
import com.casestudy.casestudy.service.blogs.CommentService;
import com.casestudy.casestudy.service.blogs.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.Optional;


@Controller
@RequestMapping("blog")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    @ModelAttribute("categories")
    public Iterable<Category> categories(){
        return categoryService.findAll();
    }

    @GetMapping("")
    public ModelAndView getIndex( @RequestParam("s") Optional<String> keyword,@PageableDefault(size = 2) Pageable pageable){
        Page<Post> blogs ;
        ModelAndView modelAndView = new ModelAndView("/blogs/blog");
        if(keyword.isPresent()){
            blogs = postService.findAllByTitle(keyword.get(),pageable);
            modelAndView.addObject("keyword",keyword.get());
            if(!blogs.hasContent()){
                modelAndView.addObject("mess","No result");
            }
        }else {
            blogs = postService.findAll(pageable);
        }
        modelAndView.addObject("blogs",blogs);
        return modelAndView;
    }

    @GetMapping("{id}")
    public ModelAndView findById(@PathVariable("id") Long id){
        Post post = postService.findById(id);
        Iterable<Comment> comments = commentService.findAllByPost(id);
        ModelAndView modelAndView = new ModelAndView("/blogs/blog-detail");
        modelAndView.addObject("blog", post);
        modelAndView.addObject("comment",comments);
        return modelAndView;
    }

    @GetMapping("create")
    public ModelAndView showCreationForm(){
        ModelAndView modelAndView = new ModelAndView("/blogs/create");
        modelAndView.addObject("post", new Post());
        return modelAndView;
    }

    @PostMapping("create")
    public ModelAndView savePost(@ModelAttribute Post post, Principal principal){
        Users currentUser = userService.findUsersByUserName(principal.getName());
        post.setUsers(currentUser);
        postService.save(post);
        ModelAndView modelAndView = new ModelAndView("/blogs/create");
        modelAndView.addObject("post", new Post());
        modelAndView.addObject("mess", "Post create successfully");
        return modelAndView;
    }

    @GetMapping("{id}/update")
    public ModelAndView edit(@PathVariable Long id){
        Post post = postService.findById(id);
        if(post != null){
            ModelAndView modelAndView = new ModelAndView("/blogs/update");
            modelAndView.addObject("post",post);
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("blogs/404");
            return modelAndView;
        }
    }

    @PostMapping("{id}/update")
    public ModelAndView edit(@ModelAttribute Post post){
        postService.save(post);
        ModelAndView modelAndView = new ModelAndView("/blogs/update");
        modelAndView.addObject("post",new Post());
        modelAndView.addObject("message","Update post successfully");
        return modelAndView;
    }

    @GetMapping("blog/{id}/delete")
    public ModelAndView getdelete(@ModelAttribute("post")Post post,Long id){
        ModelAndView mv = new ModelAndView("/blogs/delete");
        mv.addObject("post",post);
        return mv;
    }

    @PostMapping("blog/delete")
    public ModelAndView delete(@ModelAttribute("post")Post post,Long id){
        postService.findById(id);

        ModelAndView mv = new ModelAndView("/blogs/delete");
        mv.addObject("mess","Delete posst successfully");
        postService.delete(id);
        return mv;
    }


}
