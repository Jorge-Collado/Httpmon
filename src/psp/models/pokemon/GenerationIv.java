package psp.models.pokemon;

import com.fasterxml.jackson.annotation.*;

@lombok.Data
public class GenerationIv {
    @lombok.Getter(onMethod_ = {@JsonProperty("diamond-pearl")})
    @lombok.Setter(onMethod_ = {@JsonProperty("diamond-pearl")})
    private Sprites diamondPearl;
    @lombok.Getter(onMethod_ = {@JsonProperty("heartgold-soulsilver")})
    @lombok.Setter(onMethod_ = {@JsonProperty("heartgold-soulsilver")})
    private Sprites heartgoldSoulsilver;
    @lombok.Getter(onMethod_ = {@JsonProperty("platinum")})
    @lombok.Setter(onMethod_ = {@JsonProperty("platinum")})
    private Sprites platinum;
}
