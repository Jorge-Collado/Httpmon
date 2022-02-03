package psp.models.pokemon;

import com.fasterxml.jackson.annotation.*;

@lombok.Data
public class GenerationI {
    @lombok.Getter(onMethod_ = {@JsonProperty("red-blue")})
    @lombok.Setter(onMethod_ = {@JsonProperty("red-blue")})
    private RedBlue redBlue;
    @lombok.Getter(onMethod_ = {@JsonProperty("yellow")})
    @lombok.Setter(onMethod_ = {@JsonProperty("yellow")})
    private RedBlue yellow;
}
