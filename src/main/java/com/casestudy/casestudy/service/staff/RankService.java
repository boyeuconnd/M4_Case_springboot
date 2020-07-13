package com.casestudy.casestudy.service.staff;


import com.casestudy.casestudy.models.Rank;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface RankService {
    Iterable<Rank> showRanks();


}
