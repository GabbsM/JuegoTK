package com.espai.JuegoTK.controller;

import com.espai.JuegoTK.client.model.GameDTO;
import com.espai.JuegoTK.service.ApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ApiController {

    private final ApiService service;

    @GetMapping("/games")
    public List<GameDTO> getAll(){
        return service.getAll();
    }
}
