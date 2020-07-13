package com.casestudy.casestudy.repositories.blogs;


import com.casestudy.casestudy.models.blogs.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

}
