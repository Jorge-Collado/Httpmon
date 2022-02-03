package psp.models.pokemon;

import com.fasterxml.jackson.annotation.*;

@lombok.Data
public class GenerationV {
    @lombok.Getter(onMethod_ = {@JsonProperty("black-white")})
    @lombok.Setter(onMethod_ = {@JsonProperty("black-white")})
    private Sprites blackWhite;
}
