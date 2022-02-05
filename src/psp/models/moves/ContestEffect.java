package psp.models.moves;

import com.fasterxml.jackson.annotation.*;

@lombok.Data
public class ContestEffect {
    @lombok.Getter(onMethod_ = {@JsonProperty("url")})
    @lombok.Setter(onMethod_ = {@JsonProperty("url")})
    private String url;
}
