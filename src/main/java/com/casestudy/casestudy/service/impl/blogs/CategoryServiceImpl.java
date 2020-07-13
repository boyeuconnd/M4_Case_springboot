package com.casestudy.casestudy.service.impl.blogs;



import com.casestudy.casestudy.models.blogs.Category;
import com.casestudy.casestudy.repositories.blogs.CategoryRepository;
import com.casestudy.casestudy.repositories.blogs.PostRepository;
import com.casestudy.casestudy.service.blogs.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }


}
