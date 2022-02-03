package psp.models.pokemon;

import com.fasterxml.jackson.annotation.*;

@lombok.Data
public class GenerationIii {
    @lombok.Getter(onMethod_ = {@JsonProperty("emerald")})
    @lombok.Setter(onMethod_ = {@JsonProperty("emerald")})
    private Emerald emerald;
    @lombok.Getter(onMethod_ = {@JsonProperty("firered-leafgreen")})
    @lombok.Setter(onMethod_ = {@JsonProperty("firered-leafgreen")})
    private Gold fireredLeafgreen;
    @lombok.Getter(onMethod_ = {@JsonProperty("ruby-sapphire")})
    @lombok.Setter(onMethod_ = {@JsonProperty("ruby-sapphire")})
    private Gold rubySapphire;
}
