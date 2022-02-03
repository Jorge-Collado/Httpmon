package psp.models.pokemon;

import com.fasterxml.jackson.annotation.*;

@lombok.Data
public class VersionDetail {
    @lombok.Getter(onMethod_ = {@JsonProperty("rarity")})
    @lombok.Setter(onMethod_ = {@JsonProperty("rarity")})
    private long rarity;
    @lombok.Getter(onMethod_ = {@JsonProperty("version")})
    @lombok.Setter(onMethod_ = {@JsonProperty("version")})
    private Species version;
}
