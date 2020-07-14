package com.casestudy.casestudy.service.gallery;


import com.casestudy.casestudy.models.gallery.Gallery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GalleryService {
    Iterable<Gallery> findAll();

    Gallery save(Gallery gallery);

    void delete(Long id);
}
