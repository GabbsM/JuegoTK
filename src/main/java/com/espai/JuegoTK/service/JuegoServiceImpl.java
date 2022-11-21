package com.espai.JuegoTK.service;
import com.espai.JuegoTK.client.RawGClient;
import com.espai.JuegoTK.client.model.GameDTO;
import com.espai.JuegoTK.client.model.GameResponse;
import com.espai.JuegoTK.model.JuegoFicha;
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
    private ApiService apiService;

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
        return null;
    }


    @Override
    public void eliminar(Integer id) {
        juegoRepository.deleteById(id);
    }

    @Override
    public JuegoFicha getJuego(Integer id) {
        Juego juego = juegoRepository.findById(id).orElseThrow();

        JuegoFicha juegoFicha = JuegoFicha.builder()
                .titulo(juego.getTitulo())
                .genero(juego.getGenero().getGenero())
                .desarrollador(juego.getDesarrollador())
                .plataforma(juego.getPlataforma())
                .nota(juego.getNota())
                .estado(juego.getEstado())
                .build();

        //  TODO fill juegoficha with more data from gamedto
        GameDTO game = apiService.getById(juego.getApiId());

        juegoFicha.setImagen(game.getBackground_image());
        juegoFicha.setMetacritic(game.getMetacritic());

        return juegoFicha;
    }

    public List<GameDTO> searchGameByTitle(String title) {

        return apiService.getByTitle(title);

    }

    public GameDTO getApiGameById(int id) {

        return apiService.getById(id);

    }
}


