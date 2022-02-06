package psp.models.pokemon;

import com.fasterxml.jackson.annotation.*;

@lombok.Data
public class Stat {
    @lombok.Getter(onMethod_ = {@JsonProperty("base_stat")})
    @lombok.Setter(onMethod_ = {@JsonProperty("base_stat")})
    private long baseStat;
    @lombok.Getter(onMethod_ = {@JsonProperty("effort")})
    @lombok.Setter(onMethod_ = {@JsonProperty("effort")})
    private long effort;
    @lombok.Getter(onMethod_ = {@JsonProperty("stat")})
    @lombok.Setter(onMethod_ = {@JsonProperty("stat")})
    private PokemonSpecies stat;
}
