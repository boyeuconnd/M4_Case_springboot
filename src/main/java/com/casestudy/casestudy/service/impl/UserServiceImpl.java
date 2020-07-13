package com.casestudy.casestudy.service.impl;


import com.casestudy.casestudy.models.Role;
import com.casestudy.casestudy.models.Users;
import com.casestudy.casestudy.repositories.UserRepository;
import com.casestudy.casestudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public Page<Users> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public Iterable<Users> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Users findOne(Long id) {
        return userRepository.findById(id).get();


    }

    @Override
    public Users save(Users user) {
        return userRepository.save(user);
    }

    @Override
    public Users delete(Long id) {
        Users delete = userRepository.findById(id).get();
        userRepository.delete(delete);
        return delete;
    }

    @Override
    public Page<Users> findAllByRoleEquals(Role role, Pageable pageable) {
        return userRepository.findAllByRoleEquals(role,pageable);
    }

    @Override
    public Users findUsersByUserName(String username) {
        return userRepository.findUsersByUserName(username);
    }
}
