package com.casestudy.casestudy.service.impl.staff;


import com.casestudy.casestudy.models.Rank;
import com.casestudy.casestudy.repositories.RankRepository;
import com.casestudy.casestudy.service.staff.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class RankServiceImpl implements RankService {
    @Autowired
    private RankRepository rankRepository;

    @Override
    public Iterable<Rank> showRanks() {
        return rankRepository.findAll();
    }
}
