package com.casestudy.casestudy.repositories.gallery;

import com.casestudy.casestudy.models.gallery.Gallery;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GalleryRepository extends CrudRepository<Gallery,Long> {
}
