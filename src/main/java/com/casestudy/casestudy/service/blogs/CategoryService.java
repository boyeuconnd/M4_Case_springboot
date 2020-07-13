package com.casestudy.casestudy.service.blogs;


import com.casestudy.casestudy.models.blogs.Category;

public interface CategoryService {

    Iterable<Category> findAll();


    Category findById(Long id);

    Category save(Category category);

    void delete(Long id);

}
