package com.espai.JuegoTK.client;

import com.espai.JuegoTK.client.model.GameResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "apiGame" , url = "${rawg.api.baseurl}")
public interface RawGClient {

    @GetMapping(value = "/games")
    GameResponse getAll(@RequestParam("key") String apiKey,
                        @RequestParam("search") String search);

    @GetMapping(value = "/games/{id}")
    GameResponse.Game getById(@RequestParam("key") String apiKey,
                              @PathVariable("id") int id);
}
