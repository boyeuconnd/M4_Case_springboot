package com.casestudy.casestudy.service;



import com.casestudy.casestudy.models.Rank;
import com.casestudy.casestudy.models.Role;
import com.casestudy.casestudy.models.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface UserService {
    Page<Users> findAll(Pageable pageable);
    Iterable<Users> findAll();
    Users findOne(Long id);

    Users save(Users user);

    Users delete(Long id);

    Page<Users> findAllByRoleEquals(Role role, Pageable pageable);

    Users findUsersByUserName(String username);

    Page<Users> findAllByUserNameContaining(String value,Pageable pageable);

    Iterable<Users> findAllByRoleEqualsAndNickNameContaining(Role role,String nickname);

    Iterable<Users> findAllByRoleAndRank(Role role, Rank rank);

    Long countAll();
}
