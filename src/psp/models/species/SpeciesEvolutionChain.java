package psp.models.species;

import com.fasterxml.jackson.annotation.*;

@lombok.Data
public class SpeciesEvolutionChain {
    @lombok.Getter(onMethod_ = {@JsonProperty("url")})
    @lombok.Setter(onMethod_ = {@JsonProperty("url")})
    private String url;
}
