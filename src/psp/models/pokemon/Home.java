package psp.models.pokemon;

import com.fasterxml.jackson.annotation.*;

@lombok.Data
public class Home {
    @lombok.Getter(onMethod_ = {@JsonProperty("front_default")})
    @lombok.Setter(onMethod_ = {@JsonProperty("front_default")})
    private String frontDefault;
    @lombok.Getter(onMethod_ = {@JsonProperty("front_female")})
    @lombok.Setter(onMethod_ = {@JsonProperty("front_female")})
    private Object frontFemale;
    @lombok.Getter(onMethod_ = {@JsonProperty("front_shiny")})
    @lombok.Setter(onMethod_ = {@JsonProperty("front_shiny")})
    private String frontShiny;
    @lombok.Getter(onMethod_ = {@JsonProperty("front_shiny_female")})
    @lombok.Setter(onMethod_ = {@JsonProperty("front_shiny_female")})
    private Object frontShinyFemale;
}
