package sharipov.entityes;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GifUrl {
    @JsonProperty("embed_url")
    String url;
}
