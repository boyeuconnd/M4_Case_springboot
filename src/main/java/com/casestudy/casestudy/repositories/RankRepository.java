package com.casestudy.casestudy.repositories;


import com.casestudy.casestudy.models.Rank;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RankRepository extends CrudRepository<Rank,Long> {
}
