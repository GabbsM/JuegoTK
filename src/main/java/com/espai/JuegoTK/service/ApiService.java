package com.espai.JuegoTK.service;

import com.espai.JuegoTK.client.RawGClient;
import com.espai.JuegoTK.client.model.GameDTO;
import com.espai.JuegoTK.client.model.GameResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApiService {

    private final RawGClient client;
    private final String apiKey;

    public ApiService(@Value("${rawg.api.apiKey}") String apiKey, RawGClient client) {
        this.apiKey = apiKey;
        this.client = client;

    }

    public List<GameDTO> getAll(){

        return getByTitle(null);
    }

    public List<GameDTO> getByTitle(String title){

        GameResponse response = client.getAll(apiKey, title);
        List<GameResponse.Game> apiGame = response.getResults();
        List<GameDTO> userGame = new ArrayList<>();

        for (int i = 0; i < apiGame.size(); i++) {
            userGame.add(apiGame.get(i).convert());
        }
        return userGame;
    }

    public GameDTO getById(int id){

        GameResponse.Game game = client.getById(apiKey,id);
        return  game.convert();

    }
}
