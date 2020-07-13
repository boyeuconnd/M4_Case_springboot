package com.casestudy.casestudy.repositories;


import com.casestudy.casestudy.models.Status;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends CrudRepository<Status,Long> {
}
