package com.casestudy.casestudy.formatter;

import com.casestudy.casestudy.models.Rank;
import com.casestudy.casestudy.service.staff.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;


@Component
public class RankFormatter implements Formatter<Rank> {

    private RankService rankService;

    @Autowired
    public RankFormatter (RankService rankService){this.rankService=rankService;}


    @Override
    public Rank parse(String text, Locale locale) throws ParseException {
        return rankService.findById(Long.parseLong(text));
    }


    @Override
    public String print(Rank object, Locale locale) {
        return "[" + object.getId() + ", " +object.getRanks() + "]";
    }
}
