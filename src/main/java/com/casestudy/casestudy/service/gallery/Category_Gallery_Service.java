package com.casestudy.casestudy.service.gallery;

import com.casestudy.casestudy.models.gallery.Category_Gallery;

public interface Category_Gallery_Service {

    Iterable<Category_Gallery> findAll();


    Category_Gallery findById(Long id);

    Category_Gallery save(Category_Gallery categoryGallery);

    void delete(Long id);
}
