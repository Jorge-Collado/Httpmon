package psp.models.pokemon;

import com.fasterxml.jackson.annotation.*;

@lombok.Data
public class PokemonType {
    @lombok.Getter(onMethod_ = {@JsonProperty("slot")})
    @lombok.Setter(onMethod_ = {@JsonProperty("slot")})
    private long slot;
    @lombok.Getter(onMethod_ = {@JsonProperty("type")})
    @lombok.Setter(onMethod_ = {@JsonProperty("type")})
    private Species type;
}
