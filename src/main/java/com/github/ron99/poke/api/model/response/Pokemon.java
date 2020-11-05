package com.github.ron99.poke.api.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pokemon {

    @JsonProperty("base_experience")
    private Integer baseExperience;

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("is_default")
    private Boolean isDefault;

    @JsonProperty("moves")
    private List<Move> moves;

    @JsonProperty("order")
    private Integer order;

    @JsonProperty("sprites")
    private Sprites sprites;

    @JsonProperty("abilities")
    private List<Ability> abilities;

    @JsonProperty("stats")
    private List<Stats> stats;
}
