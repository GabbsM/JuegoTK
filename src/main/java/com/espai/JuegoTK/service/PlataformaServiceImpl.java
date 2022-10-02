package com.espai.JuegoTK.service;

import com.espai.JuegoTK.persistence.entity.Plataforma;
import com.espai.JuegoTK.persistence.repository.PlataformaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlataformaServiceImpl implements IPlataformaService{

    @Autowired
    PlataformaRepository plataformaRepository;


    @Override
    public List<Plataforma> listaPlataformas() {
        return (List<Plataforma>) plataformaRepository.findAll();
    }
}
