package com.espai.JuegoTK.model;

import com.espai.JuegoTK.persistence.entity.Estado;
import com.espai.JuegoTK.persistence.entity.Genero;
import com.espai.JuegoTK.persistence.entity.Plataforma;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JuegoFicha {

    private String titulo;
    private String desarrollador;
    private int nota;
    private Estado estado;
    private Plataforma plataforma;
    private String genero;
    private String imagen;
    private Integer metacritic;
    private String released;

    //TODO: add more fields from API

}
