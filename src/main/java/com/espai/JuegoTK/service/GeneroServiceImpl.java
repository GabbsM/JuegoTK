package com.espai.JuegoTK.service;

import com.espai.JuegoTK.persistence.entity.Genero;
import com.espai.JuegoTK.persistence.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroServiceImpl implements IGeneroService{

    @Autowired
    private GeneroRepository generoRepository;

    @Override
    public List<Genero> listaGeneros() {
        return (List<Genero>) generoRepository.findAll();
    }
}
