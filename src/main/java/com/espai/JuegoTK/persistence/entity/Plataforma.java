package com.espai.JuegoTK.persistence.entity;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "plataformas")
public class Plataforma implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String plataforma;
}