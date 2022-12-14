package com.espai.JuegoTK.service;

import com.espai.JuegoTK.model.JuegoFicha;
import com.espai.JuegoTK.persistence.entity.Juego;

import java.util.List;
import java.util.Optional;

public interface IJuegoService {

        List<Juego> listarTodos();
        void guardar(Juego juego);
        Juego buscarPorId (Integer id);
        JuegoFicha getJuego (Integer id);
        void eliminar (Integer id);

}
