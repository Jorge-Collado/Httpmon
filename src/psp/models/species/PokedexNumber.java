package psp.models.species;

import com.fasterxml.jackson.annotation.*;

@lombok.Data
public class PokedexNumber {
    @lombok.Getter(onMethod_ = {@JsonProperty("entry_number")})
    @lombok.Setter(onMethod_ = {@JsonProperty("entry_number")})
    private long entryNumber;
    @lombok.Getter(onMethod_ = {@JsonProperty("pokedex")})
    @lombok.Setter(onMethod_ = {@JsonProperty("pokedex")})
    private Color pokedex;
}
