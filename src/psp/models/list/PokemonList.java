package psp.models.list;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

@lombok.Data
public class PokemonList {
    @lombok.Getter(onMethod_ = {@JsonProperty("count")})
    @lombok.Setter(onMethod_ = {@JsonProperty("count")})
    private long count;
    @lombok.Getter(onMethod_ = {@JsonProperty("next")})
    @lombok.Setter(onMethod_ = {@JsonProperty("next")})
    private String next;
    @lombok.Getter(onMethod_ = {@JsonProperty("previous")})
    @lombok.Setter(onMethod_ = {@JsonProperty("previous")})
    private Object previous;
    @lombok.Getter(onMethod_ = {@JsonProperty("results")})
    @lombok.Setter(onMethod_ = {@JsonProperty("results")})
    private List<Result> results;
}
