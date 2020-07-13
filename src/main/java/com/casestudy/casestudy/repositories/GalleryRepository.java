package com.casestudy.casestudy.repositories;

import com.casestudy.casestudy.models.Gallery;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GalleryRepository extends PagingAndSortingRepository<Gallery,Long> {

}
