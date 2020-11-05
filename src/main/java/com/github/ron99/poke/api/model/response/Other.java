package com.github.ron99.poke.api.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Other {

    @JsonProperty("dream_world")
    private DreamWorld dream_world;

    @JsonProperty("official-artwork")
    private DreamWorld artwork;
}
