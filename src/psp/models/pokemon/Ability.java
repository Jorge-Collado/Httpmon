package psp.models.pokemon;

import com.fasterxml.jackson.annotation.*;

@lombok.Data
public class Ability {
    @lombok.Getter(onMethod_ = {@JsonProperty("ability")})
    @lombok.Setter(onMethod_ = {@JsonProperty("ability")})
    private Species ability;
    @lombok.Getter(onMethod_ = {@JsonProperty("is_hidden")})
    @lombok.Setter(onMethod_ = {@JsonProperty("is_hidden")})
    private boolean isHidden;
    @lombok.Getter(onMethod_ = {@JsonProperty("slot")})
    @lombok.Setter(onMethod_ = {@JsonProperty("slot")})
    private long slot;
}
