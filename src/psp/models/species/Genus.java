package psp.models.species;

import com.fasterxml.jackson.annotation.*;

@lombok.Data
public class Genus {
    @lombok.Getter(onMethod_ = {@JsonProperty("genus")})
    @lombok.Setter(onMethod_ = {@JsonProperty("genus")})
    private String genus;
    @lombok.Getter(onMethod_ = {@JsonProperty("language")})
    @lombok.Setter(onMethod_ = {@JsonProperty("language")})
    private Color language;
}
