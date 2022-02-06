package psp.models.species;

import com.fasterxml.jackson.annotation.*;

@lombok.Data
public class Name {
    @lombok.Getter(onMethod_ = {@JsonProperty("language")})
    @lombok.Setter(onMethod_ = {@JsonProperty("language")})
    private Color language;
    @lombok.Getter(onMethod_ = {@JsonProperty("name")})
    @lombok.Setter(onMethod_ = {@JsonProperty("name")})
    private String name;
}
