package com.espai.JuegoTK.persistence.repository;
import com.espai.JuegoTK.persistence.entity.Juego;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JuegoRepository extends CrudRepository<Juego,Integer> {
}
