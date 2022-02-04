package psp.models.moves;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

@lombok.Data
public class Normal {
    @lombok.Getter(onMethod_ = {@JsonProperty("use_after")})
    @lombok.Setter(onMethod_ = {@JsonProperty("use_after")})
    private List<ContestType> useAfter;
    @lombok.Getter(onMethod_ = {@JsonProperty("use_before")})
    @lombok.Setter(onMethod_ = {@JsonProperty("use_before")})
    private Object useBefore;
}
