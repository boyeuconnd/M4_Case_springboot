package com.casestudy.casestudy.service.impl.staff;


import com.casestudy.casestudy.models.Status;
import com.casestudy.casestudy.repositories.StatusRepository;
import com.casestudy.casestudy.service.staff.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class StatusServiceImpl implements StatusService {
    @Autowired
    private StatusRepository statusRepository;


    @Override
    public Iterable<Status> showStatus() {
        return statusRepository.findAll();
    }

    @Override
    public Status findById(Long id) {
        return statusRepository.findById(id).get();
    }


}
