package com.github.ron99.poke.api.repository;

import com.github.ron99.poke.api.model.database.PokemonDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends JpaRepository<PokemonDB, Integer> {
}
