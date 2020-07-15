package com.casestudy.casestudy.repositories.blogs;
import com.casestudy.casestudy.models.blogs.Comment;
import com.casestudy.casestudy.models.blogs.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment,Long> {
    List<Comment> findCommentsByPost(Post post);
}
