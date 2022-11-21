package com.espai.JuegoTK.client.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GameDTO {
    Integer id;
    String titulo;
    Integer metacritic;
    String background_image;
}
