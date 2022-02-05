package psp.models.moves;

import com.fasterxml.jackson.annotation.*;

@lombok.Data
public class Meta {
    @lombok.Getter(onMethod_ = {@JsonProperty("ailment")})
    @lombok.Setter(onMethod_ = {@JsonProperty("ailment")})
    private ContestType ailment;
    @lombok.Getter(onMethod_ = {@JsonProperty("ailment_chance")})
    @lombok.Setter(onMethod_ = {@JsonProperty("ailment_chance")})
    private long ailmentChance;
    @lombok.Getter(onMethod_ = {@JsonProperty("category")})
    @lombok.Setter(onMethod_ = {@JsonProperty("category")})
    private ContestType category;
    @lombok.Getter(onMethod_ = {@JsonProperty("crit_rate")})
    @lombok.Setter(onMethod_ = {@JsonProperty("crit_rate")})
    private long critRate;
    @lombok.Getter(onMethod_ = {@JsonProperty("drain")})
    @lombok.Setter(onMethod_ = {@JsonProperty("drain")})
    private long drain;
    @lombok.Getter(onMethod_ = {@JsonProperty("flinch_chance")})
    @lombok.Setter(onMethod_ = {@JsonProperty("flinch_chance")})
    private long flinchChance;
    @lombok.Getter(onMethod_ = {@JsonProperty("healing")})
    @lombok.Setter(onMethod_ = {@JsonProperty("healing")})
    private long healing;
    @lombok.Getter(onMethod_ = {@JsonProperty("max_hits")})
    @lombok.Setter(onMethod_ = {@JsonProperty("max_hits")})
    private Object maxHits;
    @lombok.Getter(onMethod_ = {@JsonProperty("max_turns")})
    @lombok.Setter(onMethod_ = {@JsonProperty("max_turns")})
    private Object maxTurns;
    @lombok.Getter(onMethod_ = {@JsonProperty("min_hits")})
    @lombok.Setter(onMethod_ = {@JsonProperty("min_hits")})
    private Object minHits;
    @lombok.Getter(onMethod_ = {@JsonProperty("min_turns")})
    @lombok.Setter(onMethod_ = {@JsonProperty("min_turns")})
    private Object minTurns;
    @lombok.Getter(onMethod_ = {@JsonProperty("stat_chance")})
    @lombok.Setter(onMethod_ = {@JsonProperty("stat_chance")})
    private long statChance;
}
