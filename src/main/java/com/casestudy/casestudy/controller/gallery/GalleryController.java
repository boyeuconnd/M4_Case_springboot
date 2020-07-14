package com.casestudy.casestudy.controller.gallery;


import com.casestudy.casestudy.models.gallery.Gallery;
import com.casestudy.casestudy.service.gallery.Category_Gallery_Service;
import com.casestudy.casestudy.service.gallery.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("gallery")
public class GalleryController {

    @Autowired
    Category_Gallery_Service category_gallery_service;

    @Autowired
    GalleryService galleryService;

    @GetMapping("")
    public ModelAndView getGalery(){
        Iterable<Gallery> galleries = galleryService.findAll();
        ModelAndView mv = new ModelAndView("gallery/gallery");
        mv.addObject("imgs",galleries);
        return mv;
    }

//    @GetMapping("")
//    public ModelAndView getIndex(){
////        Iterable<Gallery> galleries = galleryService.findAll();
////        ModelAndView modelAndView = new ModelAndView("/gallery/gallegy");
////        modelAndView.addObject("galleries",galleries);
//        return modelAndView;
//    }
}
