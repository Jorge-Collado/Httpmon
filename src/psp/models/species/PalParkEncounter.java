package psp.models.species;

import com.fasterxml.jackson.annotation.*;

@lombok.Data
public class PalParkEncounter {
    @lombok.Getter(onMethod_ = {@JsonProperty("area")})
    @lombok.Setter(onMethod_ = {@JsonProperty("area")})
    private Color area;
    @lombok.Getter(onMethod_ = {@JsonProperty("base_score")})
    @lombok.Setter(onMethod_ = {@JsonProperty("base_score")})
    private long baseScore;
    @lombok.Getter(onMethod_ = {@JsonProperty("rate")})
    @lombok.Setter(onMethod_ = {@JsonProperty("rate")})
    private long rate;
}
