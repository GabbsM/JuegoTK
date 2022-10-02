package com.espai.JuegoTK.persistence.repository;

import com.espai.JuegoTK.persistence.entity.Genero;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GeneroRepository extends CrudRepository<Genero, Integer> {

}
