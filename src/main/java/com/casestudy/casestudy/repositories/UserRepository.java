package com.casestudy.casestudy.repositories;


import com.casestudy.casestudy.models.Rank;
import com.casestudy.casestudy.models.Role;
import com.casestudy.casestudy.models.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<Users,Long> {

    Page<Users> findAllByRoleEquals(Role role, Pageable pageable);

    Iterable<Users> findAllByRoleAndRank(Role role, Rank rank);

    Users findUsersByUserName(String username);
}
