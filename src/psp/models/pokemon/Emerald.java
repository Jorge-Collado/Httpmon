package psp.models.pokemon;

import com.fasterxml.jackson.annotation.*;

@lombok.Data
public class Emerald {
    @lombok.Getter(onMethod_ = {@JsonProperty("front_default")})
    @lombok.Setter(onMethod_ = {@JsonProperty("front_default")})
    private String frontDefault;
    @lombok.Getter(onMethod_ = {@JsonProperty("front_shiny")})
    @lombok.Setter(onMethod_ = {@JsonProperty("front_shiny")})
    private String frontShiny;
}
