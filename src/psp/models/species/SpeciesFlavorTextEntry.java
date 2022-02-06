package psp.models.species;

import com.fasterxml.jackson.annotation.*;

@lombok.Data
public class SpeciesFlavorTextEntry {
    @lombok.Getter(onMethod_ = {@JsonProperty("flavor_text")})
    @lombok.Setter(onMethod_ = {@JsonProperty("flavor_text")})
    private String flavorText;
    @lombok.Getter(onMethod_ = {@JsonProperty("language")})
    @lombok.Setter(onMethod_ = {@JsonProperty("language")})
    private Color language;
    @lombok.Getter(onMethod_ = {@JsonProperty("version")})
    @lombok.Setter(onMethod_ = {@JsonProperty("version")})
    private Color version;
}
