package com.casestudy.casestudy.service.impl.gallery;


import com.casestudy.casestudy.models.gallery.Gallery;
import com.casestudy.casestudy.repositories.gallery.GalleryRepository;
import com.casestudy.casestudy.service.gallery.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class GalleryServiceImpl implements GalleryService {

    @Autowired
    GalleryRepository galleryRepository;

    @Override
    public Iterable<Gallery> findAll() {
        return galleryRepository.findAll();
    }

    @Override
    public Gallery save(Gallery gallery) {
        return galleryRepository.save(gallery);
    }

    @Override
    public void delete(Long id) {
         galleryRepository.deleteById(id);
    }
}
