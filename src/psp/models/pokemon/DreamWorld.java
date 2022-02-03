package psp.models.pokemon;

import com.fasterxml.jackson.annotation.*;

@lombok.Data
public class DreamWorld {
    @lombok.Getter(onMethod_ = {@JsonProperty("front_default")})
    @lombok.Setter(onMethod_ = {@JsonProperty("front_default")})
    private String frontDefault;
    @lombok.Getter(onMethod_ = {@JsonProperty("front_female")})
    @lombok.Setter(onMethod_ = {@JsonProperty("front_female")})
    private Object frontFemale;
}
