package com.casestudy.casestudy.service.impl.gallery;

import com.casestudy.casestudy.models.gallery.Category_Gallery;
import com.casestudy.casestudy.repositories.gallery.Category_Gallery_Repository;
import com.casestudy.casestudy.service.gallery.Category_Gallery_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Category_Gallery_ServiceImpl implements Category_Gallery_Service {

    @Autowired
    Category_Gallery_Repository category_gallery_repository;

    @Override
    public Iterable<Category_Gallery> findAll() {
        return category_gallery_repository.findAll();
    }

    @Override
    public Category_Gallery findById(Long id) {
        return category_gallery_repository.findById(id).get();
    }

    @Override
    public Category_Gallery save(Category_Gallery categoryGallery) {
        return category_gallery_repository.save(categoryGallery);
    }

    @Override
    public void delete(Long id) {
        category_gallery_repository.deleteById(id);
    }
}
