package psp.models.pokemon;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

@lombok.Data
public class PokemonMove {
    @lombok.Getter(onMethod_ = {@JsonProperty("move")})
    @lombok.Setter(onMethod_ = {@JsonProperty("move")})
    private PokemonSpecies move;
    @lombok.Getter(onMethod_ = {@JsonProperty("version_group_details")})
    @lombok.Setter(onMethod_ = {@JsonProperty("version_group_details")})
    private List<VersionGroupDetail> versionGroupDetails;

    @Override
    public String toString() {
        return move.getName().toUpperCase();
    }
    
}
