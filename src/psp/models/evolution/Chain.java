package psp.models.evolution;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

@lombok.Data
public class Chain {
    @lombok.Getter(onMethod_ = {@JsonProperty("evolution_details")})
    @lombok.Setter(onMethod_ = {@JsonProperty("evolution_details")})
    private List<EvolutionDetail> evolutionDetails;
    @lombok.Getter(onMethod_ = {@JsonProperty("evolves_to")})
    @lombok.Setter(onMethod_ = {@JsonProperty("evolves_to")})
    private List<Chain> evolvesTo;
    @lombok.Getter(onMethod_ = {@JsonProperty("is_baby")})
    @lombok.Setter(onMethod_ = {@JsonProperty("is_baby")})
    private Boolean isBaby;
    @lombok.Getter(onMethod_ = {@JsonProperty("species")})
    @lombok.Setter(onMethod_ = {@JsonProperty("species")})
    private EvolutionSpecies species;
}
