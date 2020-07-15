package com.casestudy.casestudy.controller.seach;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("search")
public class SearchController {
    @GetMapping("")
    public String getSearchPage(){
        return "search/search-form";
    }
}
