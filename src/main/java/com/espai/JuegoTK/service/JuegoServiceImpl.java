package com.espai.JuegoTK.service;
import com.espai.JuegoTK.persistence.entity.Juego;
import com.espai.JuegoTK.persistence.repository.JuegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class JuegoServiceImpl implements IJuegoService{

    @Autowired
    private JuegoRepository juegoRepository;


    @Override
    public List<Juego> listarTodos() {
        return (List<Juego>) juegoRepository.findAll();
    }

    @Override
    public void guardar(Juego juego) {
        juegoRepository.save(juego);
    }

    @Override
    public Juego buscarPorId(Integer id) {
        return juegoRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        juegoRepository.deleteById(id);
    }
}



