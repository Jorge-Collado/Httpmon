package psp.models.pokemon;

import com.fasterxml.jackson.annotation.*;

@lombok.Data
public class OfficialArtwork {
    @lombok.Getter(onMethod_ = {@JsonProperty("front_default")})
    @lombok.Setter(onMethod_ = {@JsonProperty("front_default")})
    private String frontDefault;
}
