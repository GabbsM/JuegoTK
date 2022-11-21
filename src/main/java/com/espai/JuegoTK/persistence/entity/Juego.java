package com.espai.JuegoTK.persistence.entity;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;



@Entity
@Data
@Table(name ="juegos")
public class Juego implements Serializable{

    private static final long serialVersionUID = 1L;



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @NotEmpty
    @Column(name = "api_id")
    private Integer apiId;

    @NotEmpty
    @Column(name = "titulo")
    private String titulo;


    @NotEmpty
    @Column(name = "desarrollador")
    private String desarrollador;

    @Column(name = "nota")
    private int nota;


    @ManyToOne
    @JoinColumn(name = "id_estado")
    private Estado estado;


    @ManyToOne
    @JoinColumn(name = "id_plataforma")
    private Plataforma plataforma;

    @ManyToOne
    @JoinColumn(name = "id_genero")
    private Genero genero;


}