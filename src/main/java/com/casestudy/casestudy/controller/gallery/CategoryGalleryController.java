package com.casestudy.casestudy.controller.gallery;


import com.casestudy.casestudy.models.gallery.Category_Gallery;
import com.casestudy.casestudy.service.gallery.Category_Gallery_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class CategoryGalleryController {

    @Autowired
    Category_Gallery_Service category_gallery_service;

    @GetMapping("")
    public ModelAndView findAll(){
        Iterable<Category_Gallery> categories = category_gallery_service.findAll();
        ModelAndView modelAndView = new ModelAndView("/gallery");
        modelAndView.addObject("categories", categories);
        return modelAndView;
    }
}
