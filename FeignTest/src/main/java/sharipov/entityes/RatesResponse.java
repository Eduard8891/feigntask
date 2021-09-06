package sharipov.entityes;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
public class RatesResponse {
    private String value;
    @JsonProperty("timestamp")
    private long timestamp;

    @JsonProperty("rates")
    private void open(Map<String, String> rate) {
        this.value = rate.get("RUB");
    }
}

