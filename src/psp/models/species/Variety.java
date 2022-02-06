package psp.models.species;

import com.fasterxml.jackson.annotation.*;

@lombok.Data
public class Variety {
    @lombok.Getter(onMethod_ = {@JsonProperty("is_default")})
    @lombok.Setter(onMethod_ = {@JsonProperty("is_default")})
    private boolean isDefault;
    @lombok.Getter(onMethod_ = {@JsonProperty("pokemon")})
    @lombok.Setter(onMethod_ = {@JsonProperty("pokemon")})
    private Color pokemon;
}
