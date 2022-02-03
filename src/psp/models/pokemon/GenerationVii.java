package psp.models.pokemon;

import com.fasterxml.jackson.annotation.*;

@lombok.Data
public class GenerationVii {
    @lombok.Getter(onMethod_ = {@JsonProperty("icons")})
    @lombok.Setter(onMethod_ = {@JsonProperty("icons")})
    private DreamWorld icons;
    @lombok.Getter(onMethod_ = {@JsonProperty("ultra-sun-ultra-moon")})
    @lombok.Setter(onMethod_ = {@JsonProperty("ultra-sun-ultra-moon")})
    private Home ultraSunUltraMoon;
}
