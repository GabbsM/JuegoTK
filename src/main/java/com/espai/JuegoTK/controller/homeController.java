package com.espai.JuegoTK.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homeController {

    @GetMapping({"index","home","/"})
    public String getIndex(){
        return "home";
    }

    @GetMapping("/logeo")
    public String login(){

        return "logeo";
    }


}
