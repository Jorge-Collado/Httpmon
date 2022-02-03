package psp.models.moves;

import com.fasterxml.jackson.annotation.*;

@lombok.Data
public class EffectEntry {
    @lombok.Getter(onMethod_ = {@JsonProperty("effect")})
    @lombok.Setter(onMethod_ = {@JsonProperty("effect")})
    private String effect;
    @lombok.Getter(onMethod_ = {@JsonProperty("language")})
    @lombok.Setter(onMethod_ = {@JsonProperty("language")})
    private ContestType language;
    @lombok.Getter(onMethod_ = {@JsonProperty("short_effect")})
    @lombok.Setter(onMethod_ = {@JsonProperty("short_effect")})
    private String shortEffect;
}
