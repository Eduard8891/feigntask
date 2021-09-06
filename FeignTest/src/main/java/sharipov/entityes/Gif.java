package sharipov.entityes;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Gif {
    @JsonProperty("data")
    private GifUrl gifUrl;
}
