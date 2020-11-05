package com.github.ron99.poke.api.model.database;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pokemon_table")
public class PokemonDB {

    @Id
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "base_experience")
    private Integer baseExperience;

    @Column(name = "artwork")
    private String artwork;

    @Column(name = "front_default")
    private String front_default;
}
