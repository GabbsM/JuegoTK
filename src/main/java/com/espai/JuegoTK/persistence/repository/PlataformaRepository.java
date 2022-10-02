package com.espai.JuegoTK.persistence.repository;

import com.espai.JuegoTK.persistence.entity.Plataforma;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlataformaRepository extends CrudRepository<Plataforma, Integer> {
}
