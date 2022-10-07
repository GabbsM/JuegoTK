package com.espai.JuegoTK.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class RawGGame {

    Integer id;
    String name;
    String description;
    Integer metacritic;
    @JsonProperty("background_image")
    String backgroundImage;
}
