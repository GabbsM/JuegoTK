package com.espai.JuegoTK.service;
import com.espai.JuegoTK.client.RawGClient;
import com.espai.JuegoTK.client.model.RawGGame;
import com.espai.JuegoTK.persistence.entity.Juego;
import com.espai.JuegoTK.persistence.repository.JuegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class JuegoServiceImpl implements IJuegoService{

    @Autowired
    private JuegoRepository juegoRepository;

    @Autowired
    private RawGClient rawGClient;


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
        Optional<Juego> juego = juegoRepository.findById(id);
        if (juego.isPresent()) {
            Integer lastOfUs2Id = 51325;
            RawGGame gameFromApi = rawGClient.getGameById(lastOfUs2Id);
            return juego.get();
        }
        return null;
    }

    @Override
    public void eliminar(Integer id) {
        juegoRepository.deleteById(id);
    }
}



