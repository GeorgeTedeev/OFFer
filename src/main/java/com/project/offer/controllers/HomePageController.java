package com.project.offer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomePageController {

    @GetMapping("/homePage")
    public String getHomePage() throws InterruptedException{
        return "index";
    }
}
