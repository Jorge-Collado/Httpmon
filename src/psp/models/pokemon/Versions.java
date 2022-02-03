package psp.models.pokemon;

import com.fasterxml.jackson.annotation.*;
import java.util.Map;

@lombok.Data
public class Versions {
    @lombok.Getter(onMethod_ = {@JsonProperty("generation-i")})
    @lombok.Setter(onMethod_ = {@JsonProperty("generation-i")})
    private GenerationI generationI;
    @lombok.Getter(onMethod_ = {@JsonProperty("generation-ii")})
    @lombok.Setter(onMethod_ = {@JsonProperty("generation-ii")})
    private GenerationIi generationIi;
    @lombok.Getter(onMethod_ = {@JsonProperty("generation-iii")})
    @lombok.Setter(onMethod_ = {@JsonProperty("generation-iii")})
    private GenerationIii generationIii;
    @lombok.Getter(onMethod_ = {@JsonProperty("generation-iv")})
    @lombok.Setter(onMethod_ = {@JsonProperty("generation-iv")})
    private GenerationIv generationIv;
    @lombok.Getter(onMethod_ = {@JsonProperty("generation-v")})
    @lombok.Setter(onMethod_ = {@JsonProperty("generation-v")})
    private GenerationV generationV;
    @lombok.Getter(onMethod_ = {@JsonProperty("generation-vi")})
    @lombok.Setter(onMethod_ = {@JsonProperty("generation-vi")})
    private Map<String, Home> generationVi;
    @lombok.Getter(onMethod_ = {@JsonProperty("generation-vii")})
    @lombok.Setter(onMethod_ = {@JsonProperty("generation-vii")})
    private GenerationVii generationVii;
    @lombok.Getter(onMethod_ = {@JsonProperty("generation-viii")})
    @lombok.Setter(onMethod_ = {@JsonProperty("generation-viii")})
    private GenerationViii generationViii;
}
