package psp.models.pokemon;

import com.fasterxml.jackson.annotation.*;

@lombok.Data
public class Crystal {
    @lombok.Getter(onMethod_ = {@JsonProperty("back_default")})
    @lombok.Setter(onMethod_ = {@JsonProperty("back_default")})
    private String backDefault;
    @lombok.Getter(onMethod_ = {@JsonProperty("back_shiny")})
    @lombok.Setter(onMethod_ = {@JsonProperty("back_shiny")})
    private String backShiny;
    @lombok.Getter(onMethod_ = {@JsonProperty("back_shiny_transparent")})
    @lombok.Setter(onMethod_ = {@JsonProperty("back_shiny_transparent")})
    private String backShinyTransparent;
    @lombok.Getter(onMethod_ = {@JsonProperty("back_transparent")})
    @lombok.Setter(onMethod_ = {@JsonProperty("back_transparent")})
    private String backTransparent;
    @lombok.Getter(onMethod_ = {@JsonProperty("front_default")})
    @lombok.Setter(onMethod_ = {@JsonProperty("front_default")})
    private String frontDefault;
    @lombok.Getter(onMethod_ = {@JsonProperty("front_shiny")})
    @lombok.Setter(onMethod_ = {@JsonProperty("front_shiny")})
    private String frontShiny;
    @lombok.Getter(onMethod_ = {@JsonProperty("front_shiny_transparent")})
    @lombok.Setter(onMethod_ = {@JsonProperty("front_shiny_transparent")})
    private String frontShinyTransparent;
    @lombok.Getter(onMethod_ = {@JsonProperty("front_transparent")})
    @lombok.Setter(onMethod_ = {@JsonProperty("front_transparent")})
    private String frontTransparent;
}
