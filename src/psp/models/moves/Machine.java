package psp.models.moves;

import com.fasterxml.jackson.annotation.*;

@lombok.Data
public class Machine {
    @lombok.Getter(onMethod_ = {@JsonProperty("machine")})
    @lombok.Setter(onMethod_ = {@JsonProperty("machine")})
    private ContestEffect machine;
    @lombok.Getter(onMethod_ = {@JsonProperty("version_group")})
    @lombok.Setter(onMethod_ = {@JsonProperty("version_group")})
    private ContestType versionGroup;
}
