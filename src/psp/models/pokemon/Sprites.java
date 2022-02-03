package psp.models.pokemon;

import com.fasterxml.jackson.annotation.*;

@lombok.Data
public class Sprites {
    @lombok.Getter(onMethod_ = {@JsonProperty("back_default")})
    @lombok.Setter(onMethod_ = {@JsonProperty("back_default")})
    private String backDefault;
    @lombok.Getter(onMethod_ = {@JsonProperty("back_female")})
    @lombok.Setter(onMethod_ = {@JsonProperty("back_female")})
    private Object backFemale;
    @lombok.Getter(onMethod_ = {@JsonProperty("back_shiny")})
    @lombok.Setter(onMethod_ = {@JsonProperty("back_shiny")})
    private String backShiny;
    @lombok.Getter(onMethod_ = {@JsonProperty("back_shiny_female")})
    @lombok.Setter(onMethod_ = {@JsonProperty("back_shiny_female")})
    private Object backShinyFemale;
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
    @lombok.Getter(onMethod_ = {@JsonProperty("other")})
    @lombok.Setter(onMethod_ = {@JsonProperty("other")})
    private Other other;
    @lombok.Getter(onMethod_ = {@JsonProperty("versions")})
    @lombok.Setter(onMethod_ = {@JsonProperty("versions")})
    private Versions versions;
    @lombok.Getter(onMethod_ = {@JsonProperty("animated")})
    @lombok.Setter(onMethod_ = {@JsonProperty("animated")})
    private Sprites animated;
}
