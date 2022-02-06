package psp.models.evolution;

import com.fasterxml.jackson.annotation.*;

@lombok.Data
public class EvolutionDetail {
    @lombok.Getter(onMethod_ = {@JsonProperty("gender")})
    @lombok.Setter(onMethod_ = {@JsonProperty("gender")})
    private Object gender;
    @lombok.Getter(onMethod_ = {@JsonProperty("held_item")})
    @lombok.Setter(onMethod_ = {@JsonProperty("held_item")})
    private Object heldItem;
    @lombok.Getter(onMethod_ = {@JsonProperty("item")})
    @lombok.Setter(onMethod_ = {@JsonProperty("item")})
    private Object item;
    @lombok.Getter(onMethod_ = {@JsonProperty("known_move")})
    @lombok.Setter(onMethod_ = {@JsonProperty("known_move")})
    private Object knownMove;
    @lombok.Getter(onMethod_ = {@JsonProperty("known_move_type")})
    @lombok.Setter(onMethod_ = {@JsonProperty("known_move_type")})
    private Object knownMoveType;
    @lombok.Getter(onMethod_ = {@JsonProperty("location")})
    @lombok.Setter(onMethod_ = {@JsonProperty("location")})
    private Object location;
    @lombok.Getter(onMethod_ = {@JsonProperty("min_affection")})
    @lombok.Setter(onMethod_ = {@JsonProperty("min_affection")})
    private Object minAffection;
    @lombok.Getter(onMethod_ = {@JsonProperty("min_beauty")})
    @lombok.Setter(onMethod_ = {@JsonProperty("min_beauty")})
    private Object minBeauty;
    @lombok.Getter(onMethod_ = {@JsonProperty("min_happiness")})
    @lombok.Setter(onMethod_ = {@JsonProperty("min_happiness")})
    private Object minHappiness;
    @lombok.Getter(onMethod_ = {@JsonProperty("min_level")})
    @lombok.Setter(onMethod_ = {@JsonProperty("min_level")})
    private Long minLevel;
    @lombok.Getter(onMethod_ = {@JsonProperty("needs_overworld_rain")})
    @lombok.Setter(onMethod_ = {@JsonProperty("needs_overworld_rain")})
    private Boolean needsOverworldRain;
    @lombok.Getter(onMethod_ = {@JsonProperty("party_species")})
    @lombok.Setter(onMethod_ = {@JsonProperty("party_species")})
    private Object partySpecies;
    @lombok.Getter(onMethod_ = {@JsonProperty("party_type")})
    @lombok.Setter(onMethod_ = {@JsonProperty("party_type")})
    private Object partyType;
    @lombok.Getter(onMethod_ = {@JsonProperty("relative_physical_stats")})
    @lombok.Setter(onMethod_ = {@JsonProperty("relative_physical_stats")})
    private Object relativePhysicalStats;
    @lombok.Getter(onMethod_ = {@JsonProperty("time_of_day")})
    @lombok.Setter(onMethod_ = {@JsonProperty("time_of_day")})
    private String timeOfDay;
    @lombok.Getter(onMethod_ = {@JsonProperty("trade_species")})
    @lombok.Setter(onMethod_ = {@JsonProperty("trade_species")})
    private Object tradeSpecies;
    @lombok.Getter(onMethod_ = {@JsonProperty("trigger")})
    @lombok.Setter(onMethod_ = {@JsonProperty("trigger")})
    private EvolutionSpecies trigger;
    @lombok.Getter(onMethod_ = {@JsonProperty("turn_upside_down")})
    @lombok.Setter(onMethod_ = {@JsonProperty("turn_upside_down")})
    private Boolean turnUpsideDown;
}
