package com.casestudy.casestudy.service.impl;


import com.casestudy.casestudy.models.Role;
import com.casestudy.casestudy.repositories.RoleRepository;
import com.casestudy.casestudy.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;


    @Override
    public Role getRoleById(Long id) {
        return roleRepository.findById(id).get();
    }
}
