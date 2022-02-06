package psp.models.pokemon;
import com.fasterxml.jackson.annotation.*;

@lombok.Data
public class VersionGroupDetail {
    @lombok.Getter(onMethod_ = {@JsonProperty("level_learned_at")})
    @lombok.Setter(onMethod_ = {@JsonProperty("level_learned_at")})
    private long levelLearnedAt;
    @lombok.Getter(onMethod_ = {@JsonProperty("move_learn_method")})
    @lombok.Setter(onMethod_ = {@JsonProperty("move_learn_method")})
    private PokemonSpecies moveLearnMethod;
    @lombok.Getter(onMethod_ = {@JsonProperty("version_group")})
    @lombok.Setter(onMethod_ = {@JsonProperty("version_group")})
    private PokemonSpecies versionGroup;
}
