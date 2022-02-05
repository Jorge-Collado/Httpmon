package psp.models.moves;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

@lombok.Data
public class Moves {
    @lombok.Getter(onMethod_ = {@JsonProperty("accuracy")})
    @lombok.Setter(onMethod_ = {@JsonProperty("accuracy")})
    private long accuracy;
    @lombok.Getter(onMethod_ = {@JsonProperty("contest_combos")})
    @lombok.Setter(onMethod_ = {@JsonProperty("contest_combos")})
    private ContestCombos contestCombos;
    @lombok.Getter(onMethod_ = {@JsonProperty("contest_effect")})
    @lombok.Setter(onMethod_ = {@JsonProperty("contest_effect")})
    private ContestEffect contestEffect;
    @lombok.Getter(onMethod_ = {@JsonProperty("contest_type")})
    @lombok.Setter(onMethod_ = {@JsonProperty("contest_type")})
    private ContestType contestType;
    @lombok.Getter(onMethod_ = {@JsonProperty("damage_class")})
    @lombok.Setter(onMethod_ = {@JsonProperty("damage_class")})
    private ContestType damageClass;
    @lombok.Getter(onMethod_ = {@JsonProperty("effect_chance")})
    @lombok.Setter(onMethod_ = {@JsonProperty("effect_chance")})
    private Object effectChance;
    @lombok.Getter(onMethod_ = {@JsonProperty("effect_changes")})
    @lombok.Setter(onMethod_ = {@JsonProperty("effect_changes")})
    private List<Object> effectChanges;
    @lombok.Getter(onMethod_ = {@JsonProperty("effect_entries")})
    @lombok.Setter(onMethod_ = {@JsonProperty("effect_entries")})
    private List<EffectEntry> effectEntries;
    @lombok.Getter(onMethod_ = {@JsonProperty("flavor_text_entries")})
    @lombok.Setter(onMethod_ = {@JsonProperty("flavor_text_entries")})
    private List<FlavorTextEntry> flavorTextEntries;
    @lombok.Getter(onMethod_ = {@JsonProperty("generation")})
    @lombok.Setter(onMethod_ = {@JsonProperty("generation")})
    private ContestType generation;
    @lombok.Getter(onMethod_ = {@JsonProperty("id")})
    @lombok.Setter(onMethod_ = {@JsonProperty("id")})
    private long id;
    @lombok.Getter(onMethod_ = {@JsonProperty("learned_by_pokemon")})
    @lombok.Setter(onMethod_ = {@JsonProperty("learned_by_pokemon")})
    private List<ContestType> learnedByPokemon;
    @lombok.Getter(onMethod_ = {@JsonProperty("machines")})
    @lombok.Setter(onMethod_ = {@JsonProperty("machines")})
    private List<Machine> machines;
    @lombok.Getter(onMethod_ = {@JsonProperty("meta")})
    @lombok.Setter(onMethod_ = {@JsonProperty("meta")})
    private Meta meta;
    @lombok.Getter(onMethod_ = {@JsonProperty("name")})
    @lombok.Setter(onMethod_ = {@JsonProperty("name")})
    private String name;
    @lombok.Getter(onMethod_ = {@JsonProperty("names")})
    @lombok.Setter(onMethod_ = {@JsonProperty("names")})
    private List<Name> names;
    @lombok.Getter(onMethod_ = {@JsonProperty("past_values")})
    @lombok.Setter(onMethod_ = {@JsonProperty("past_values")})
    private List<Object> pastValues;
    @lombok.Getter(onMethod_ = {@JsonProperty("power")})
    @lombok.Setter(onMethod_ = {@JsonProperty("power")})
    private long power;
    @lombok.Getter(onMethod_ = {@JsonProperty("pp")})
    @lombok.Setter(onMethod_ = {@JsonProperty("pp")})
    private long pp;
    @lombok.Getter(onMethod_ = {@JsonProperty("priority")})
    @lombok.Setter(onMethod_ = {@JsonProperty("priority")})
    private long priority;
    @lombok.Getter(onMethod_ = {@JsonProperty("stat_changes")})
    @lombok.Setter(onMethod_ = {@JsonProperty("stat_changes")})
    private List<Object> statChanges;
    @lombok.Getter(onMethod_ = {@JsonProperty("super_contest_effect")})
    @lombok.Setter(onMethod_ = {@JsonProperty("super_contest_effect")})
    private ContestEffect superContestEffect;
    @lombok.Getter(onMethod_ = {@JsonProperty("target")})
    @lombok.Setter(onMethod_ = {@JsonProperty("target")})
    private ContestType target;
    @lombok.Getter(onMethod_ = {@JsonProperty("type")})
    @lombok.Setter(onMethod_ = {@JsonProperty("type")})
    private ContestType type;

    @Override
    public String toString() {
        return name.toUpperCase();
    }
    
    
}
