package com.espai.JuegoTK.client;

import com.espai.JuegoTK.client.model.RawGGame;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "rawg-api", url = "https://api.rawg.io/api")
public interface RawGClient {

    @GetMapping("/games/{id}?key=67159a70d7ac44e0a39363ead4f2be60")
    RawGGame getGameById(@PathVariable("id") Integer id);
}
