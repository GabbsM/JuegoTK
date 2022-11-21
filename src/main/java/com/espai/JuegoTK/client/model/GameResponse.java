package com.espai.JuegoTK.client.model;

import lombok.Data;

import java.util.List;

@Data
public class GameResponse {

    List<Game> results;

    @Data
    public static class Game {

        Integer id;
        String name;
        Integer metacritic;
        String background_image;

        public GameDTO convert(){
            return GameDTO.builder()
                    .id(this.id)
                    .titulo(this.name)
                    .metacritic(this.metacritic)
                    .background_image(this.background_image)
                    .build();
        }
    }
}
