package com.github.ron99.poke.api.controller;

import com.github.ron99.poke.api.model.response.Pokemon;
import com.github.ron99.poke.api.services.PokeApiServices;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Api para busca de código do pedido da vtex referente as lojas São Paulo")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PokeApiController {

    private final PokeApiServices services;

    @GetMapping("/pokemon")
    public List<Pokemon> savePokemons(@RequestParam Integer from, @RequestParam Integer to){
        return services.saveAllPokemons(from, to);
    }
}
