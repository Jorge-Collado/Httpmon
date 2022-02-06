package psp.models.pokemon;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

@lombok.Data
public class HeldItem {
    @lombok.Getter(onMethod_ = {@JsonProperty("item")})
    @lombok.Setter(onMethod_ = {@JsonProperty("item")})
    private PokemonSpecies item;
    @lombok.Getter(onMethod_ = {@JsonProperty("version_details")})
    @lombok.Setter(onMethod_ = {@JsonProperty("version_details")})
    private List<VersionDetail> versionDetails;
}
