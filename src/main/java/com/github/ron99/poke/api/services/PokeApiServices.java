package com.github.ron99.poke.api.services;

import com.github.ron99.poke.api.model.database.AbilityDB;
import com.github.ron99.poke.api.model.database.MoveDB;
import com.github.ron99.poke.api.model.database.PokemonDB;
import com.github.ron99.poke.api.model.database.StatsDB;
import com.github.ron99.poke.api.model.response.Pokemon;
import com.github.ron99.poke.api.repository.AbilityRepository;
import com.github.ron99.poke.api.repository.MoveRepository;
import com.github.ron99.poke.api.repository.PokemonRepository;
import com.github.ron99.poke.api.repository.StatsRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PokeApiServices {

    private static final Logger logger = LoggerFactory.getLogger(PokeApiServices.class);
    private final RestService restService;
    private final PokemonRepository pokemonRepository;
    private final StatsRepository statsRepository;
    private final MoveRepository moveRepository;
    private final AbilityRepository abilityRepository;

    public List<Pokemon> saveAllPokemons(Integer from, Integer to){
        List<Pokemon> pokemons = new ArrayList<>();
        for (Integer i = from; i <= to; i++){
            Pokemon pokemon = restService.getById(i);
            saveAbilities(pokemon);
            savePokemon(pokemon);
            saveMoves(pokemon);
            saveStats(pokemon);
        }

        return pokemons;
    }

    private void savePokemon(Pokemon pokemon){
        PokemonDB poke = new PokemonDB();
        poke.setArtwork(pokemon.getSprites().getOther().getArtwork().getFront_default());
        poke.setFront_default(pokemon.getSprites().getOther().getDream_world().getFront_default());
        poke.setBaseExperience(pokemon.getBaseExperience());
        poke.setName(pokemon.getName());
        poke.setId(pokemon.getId());
        pokemonRepository.save(poke);
    }

    private void saveStats(Pokemon pokemon){

        pokemon.getStats().forEach(stat -> {
            StatsDB stats = new StatsDB();
            stats.setBaseStat(stat.getBaseStat());
            stats.setId(pokemon.getId());
            stats.setName(stat.getStat().getName());

            statsRepository.save(stats);
        });
    }

    private void saveMoves(Pokemon pokemon){
        pokemon.getMoves().forEach(move -> {
            MoveDB moves = new MoveDB();
            moves.setId(pokemon.getId());
            moves.setName(move.getMove().getName());
            moveRepository.save(moves);
        });
    }

    private void saveAbilities(Pokemon pokemon){
        pokemon.getAbilities().forEach(ability -> {
            AbilityDB abilities = new AbilityDB();
            abilities.setId(pokemon.getId());
            abilities.setName(ability.getAbility().getName());
            abilityRepository.save(abilities);
        });
    }
}
