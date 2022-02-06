package psp.models.evolution;

import com.fasterxml.jackson.annotation.*;

@lombok.Data
public class EvolutionChain {
    @lombok.Getter(onMethod_ = {@JsonProperty("baby_trigger_item")})
    @lombok.Setter(onMethod_ = {@JsonProperty("baby_trigger_item")})
    private Object babyTriggerItem;
    @lombok.Getter(onMethod_ = {@JsonProperty("chain")})
    @lombok.Setter(onMethod_ = {@JsonProperty("chain")})
    private Chain chain;
    @lombok.Getter(onMethod_ = {@JsonProperty("id")})
    @lombok.Setter(onMethod_ = {@JsonProperty("id")})
    private Long id;
}
