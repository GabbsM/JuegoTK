package com.espai.JuegoTK.service;

import com.espai.JuegoTK.persistence.entity.Estado;
import com.espai.JuegoTK.persistence.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoServiceImpl implements IEstadoService{

    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public List<Estado> listaEstados() {
        return (List<Estado>) estadoRepository.findAll();
    }
}
