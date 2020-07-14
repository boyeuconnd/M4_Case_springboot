package com.casestudy.casestudy.repositories.blogs;
import com.casestudy.casestudy.models.blogs.Comment;
import com.casestudy.casestudy.models.blogs.Post;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment,Long> {
    Iterable<Comment> findAllByPost(Long id);
}
