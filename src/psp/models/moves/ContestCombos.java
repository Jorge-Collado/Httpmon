package psp.models.moves;

import com.fasterxml.jackson.annotation.*;

@lombok.Data
public class ContestCombos {
    @lombok.Getter(onMethod_ = {@JsonProperty("normal")})
    @lombok.Setter(onMethod_ = {@JsonProperty("normal")})
    private Normal normal;
    @lombok.Getter(onMethod_ = {@JsonProperty("super")})
    @lombok.Setter(onMethod_ = {@JsonProperty("super")})
    private Normal contestCombosSuper;
}
