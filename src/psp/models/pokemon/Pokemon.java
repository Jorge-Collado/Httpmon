package psp.models.pokemon;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

@lombok.Data
public class Pokemon {
    @lombok.Getter(onMethod_ = {@JsonProperty("abilities")})
    @lombok.Setter(onMethod_ = {@JsonProperty("abilities")})
    private List<Ability> abilities;
    @lombok.Getter(onMethod_ = {@JsonProperty("base_experience")})
    @lombok.Setter(onMethod_ = {@JsonProperty("base_experience")})
    private long baseExperience;
    @lombok.Getter(onMethod_ = {@JsonProperty("forms")})
    @lombok.Setter(onMethod_ = {@JsonProperty("forms")})
    private List<Species> forms;
    @lombok.Getter(onMethod_ = {@JsonProperty("game_indices")})
    @lombok.Setter(onMethod_ = {@JsonProperty("game_indices")})
    private List<GameIndex> gameIndices;
    @lombok.Getter(onMethod_ = {@JsonProperty("height")})
    @lombok.Setter(onMethod_ = {@JsonProperty("height")})
    private long height;
    @lombok.Getter(onMethod_ = {@JsonProperty("held_items")})
    @lombok.Setter(onMethod_ = {@JsonProperty("held_items")})
    private List<HeldItem> heldItems;
    @lombok.Getter(onMethod_ = {@JsonProperty("id")})
    @lombok.Setter(onMethod_ = {@JsonProperty("id")})
    private long id;
    @lombok.Getter(onMethod_ = {@JsonProperty("is_default")})
    @lombok.Setter(onMethod_ = {@JsonProperty("is_default")})
    private boolean isDefault;
    @lombok.Getter(onMethod_ = {@JsonProperty("location_area_encounters")})
    @lombok.Setter(onMethod_ = {@JsonProperty("location_area_encounters")})
    private String locationAreaEncounters;
    @lombok.Getter(onMethod_ = {@JsonProperty("moves")})
    @lombok.Setter(onMethod_ = {@JsonProperty("moves")})
    private List<PokemonMove> moves;
    @lombok.Getter(onMethod_ = {@JsonProperty("name")})
    @lombok.Setter(onMethod_ = {@JsonProperty("name")})
    private String name;
    @lombok.Getter(onMethod_ = {@JsonProperty("order")})
    @lombok.Setter(onMethod_ = {@JsonProperty("order")})
    private long order;
    @lombok.Getter(onMethod_ = {@JsonProperty("past_types")})
    @lombok.Setter(onMethod_ = {@JsonProperty("past_types")})
    private List<Object> pastTypes;
    @lombok.Getter(onMethod_ = {@JsonProperty("species")})
    @lombok.Setter(onMethod_ = {@JsonProperty("species")})
    private Species species;
    @lombok.Getter(onMethod_ = {@JsonProperty("sprites")})
    @lombok.Setter(onMethod_ = {@JsonProperty("sprites")})
    private Sprites sprites;
    @lombok.Getter(onMethod_ = {@JsonProperty("stats")})
    @lombok.Setter(onMethod_ = {@JsonProperty("stats")})
    private List<Stat> stats;
    @lombok.Getter(onMethod_ = {@JsonProperty("types")})
    @lombok.Setter(onMethod_ = {@JsonProperty("types")})
    private List<PokemonType> types;
    @lombok.Getter(onMethod_ = {@JsonProperty("weight")})
    @lombok.Setter(onMethod_ = {@JsonProperty("weight")})
    private long weight;
}
