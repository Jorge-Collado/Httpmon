package psp.models.pokemon;
import com.fasterxml.jackson.annotation.*;

@lombok.Data
public class Other {
    @lombok.Getter(onMethod_ = {@JsonProperty("dream_world")})
    @lombok.Setter(onMethod_ = {@JsonProperty("dream_world")})
    private DreamWorld dreamWorld;
    @lombok.Getter(onMethod_ = {@JsonProperty("home")})
    @lombok.Setter(onMethod_ = {@JsonProperty("home")})
    private Home home;
    @lombok.Getter(onMethod_ = {@JsonProperty("official-artwork")})
    @lombok.Setter(onMethod_ = {@JsonProperty("official-artwork")})
    private OfficialArtwork officialArtwork;
}
