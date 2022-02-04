package psp.models.moves;

import com.fasterxml.jackson.annotation.*;

@lombok.Data
public class FlavorTextEntry {
    @lombok.Getter(onMethod_ = {@JsonProperty("flavor_text")})
    @lombok.Setter(onMethod_ = {@JsonProperty("flavor_text")})
    private String flavorText;
    @lombok.Getter(onMethod_ = {@JsonProperty("language")})
    @lombok.Setter(onMethod_ = {@JsonProperty("language")})
    private ContestType language;
    @lombok.Getter(onMethod_ = {@JsonProperty("version_group")})
    @lombok.Setter(onMethod_ = {@JsonProperty("version_group")})
    private ContestType versionGroup;
}
