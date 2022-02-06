package psp.models.pokemon;

import com.fasterxml.jackson.annotation.*;

@lombok.Data
public class GameIndex {
    @lombok.Getter(onMethod_ = {@JsonProperty("game_index")})
    @lombok.Setter(onMethod_ = {@JsonProperty("game_index")})
    private long gameIndex;
    @lombok.Getter(onMethod_ = {@JsonProperty("version")})
    @lombok.Setter(onMethod_ = {@JsonProperty("version")})
    private PokemonSpecies version;
}
