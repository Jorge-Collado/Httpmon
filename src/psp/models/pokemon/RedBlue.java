package psp.models.pokemon;

import com.fasterxml.jackson.annotation.*;

@lombok.Data
public class RedBlue {
    @lombok.Getter(onMethod_ = {@JsonProperty("back_default")})
    @lombok.Setter(onMethod_ = {@JsonProperty("back_default")})
    private String backDefault;
    @lombok.Getter(onMethod_ = {@JsonProperty("back_gray")})
    @lombok.Setter(onMethod_ = {@JsonProperty("back_gray")})
    private String backGray;
    @lombok.Getter(onMethod_ = {@JsonProperty("back_transparent")})
    @lombok.Setter(onMethod_ = {@JsonProperty("back_transparent")})
    private String backTransparent;
    @lombok.Getter(onMethod_ = {@JsonProperty("front_default")})
    @lombok.Setter(onMethod_ = {@JsonProperty("front_default")})
    private String frontDefault;
    @lombok.Getter(onMethod_ = {@JsonProperty("front_gray")})
    @lombok.Setter(onMethod_ = {@JsonProperty("front_gray")})
    private String frontGray;
    @lombok.Getter(onMethod_ = {@JsonProperty("front_transparent")})
    @lombok.Setter(onMethod_ = {@JsonProperty("front_transparent")})
    private String frontTransparent;
}
