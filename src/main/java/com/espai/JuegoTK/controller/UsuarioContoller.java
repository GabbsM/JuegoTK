package com.espai.JuegoTK.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuario")
public class UsuarioContoller {

    @GetMapping("/registro")
    public String registro(){

        return "registrdo";
    }

}
