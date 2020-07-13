package com.casestudy.casestudy.service.impl.blogs;


import com.casestudy.casestudy.models.blogs.Post;
import com.casestudy.casestudy.repositories.blogs.PostRepository;
import com.casestudy.casestudy.service.blogs.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Page<Post> findAll(Pageable pageable) {

        return postRepository.findAll(pageable);
    }

    @Override
    public Page<Post> findAllByTitle(String title, Pageable pageable) {
        return postRepository.findAllByTitleContaining(title,pageable);
    }

    @Override
    public Post findById(Long id) {

        return postRepository.findById(id).get();
    }

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void delete(Long id) {

        postRepository.deleteById(id);
    }

    @Override
    public Post addLike(Long blogId) {
        Post post = postRepository.findById(blogId).get();
        Long likes = post.getLikes() + 1;
        post.setLikes( likes  );
        return postRepository.save(post);
    }
}
