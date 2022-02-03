package psp.models.pokemon;

import com.fasterxml.jackson.annotation.*;

@lombok.Data
public class GenerationIi {
    @lombok.Getter(onMethod_ = {@JsonProperty("crystal")})
    @lombok.Setter(onMethod_ = {@JsonProperty("crystal")})
    private Crystal crystal;
    @lombok.Getter(onMethod_ = {@JsonProperty("gold")})
    @lombok.Setter(onMethod_ = {@JsonProperty("gold")})
    private Gold gold;
    @lombok.Getter(onMethod_ = {@JsonProperty("silver")})
    @lombok.Setter(onMethod_ = {@JsonProperty("silver")})
    private Gold silver;
}
