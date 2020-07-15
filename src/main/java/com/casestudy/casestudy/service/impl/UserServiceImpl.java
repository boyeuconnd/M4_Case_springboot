package com.casestudy.casestudy.service.impl;


import com.casestudy.casestudy.models.Role;
import com.casestudy.casestudy.models.Users;
import com.casestudy.casestudy.repositories.UserRepository;
import com.casestudy.casestudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
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

    @Override
    public Page<Users> findAllByUserNameContaining(String value, Pageable pageable) {
        return userRepository.findAllByUserNameContaining(value,pageable);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = this.findUsersByUserName(username);
        List<GrantedAuthority> rolelist = new ArrayList<>();
        rolelist.add(new SimpleGrantedAuthority(user.getRole().getRole()));
        return new User(user.getUserName(),user.getPassword(),rolelist);
    }
}
