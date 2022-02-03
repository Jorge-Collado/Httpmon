package psp.models.pokemon;
import com.fasterxml.jackson.annotation.*;

@lombok.Data
public class GenerationViii {
    @lombok.Getter(onMethod_ = {@JsonProperty("icons")})
    @lombok.Setter(onMethod_ = {@JsonProperty("icons")})
    private DreamWorld icons;
}
