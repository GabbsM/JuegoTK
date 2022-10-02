package com.espai.JuegoTK.persistence.repository;
import com.espai.JuegoTK.persistence.entity.Estado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends CrudRepository<Estado,Integer> {
}
