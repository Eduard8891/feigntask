package sharipov.config;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sharipov.interfeign.FeignClient;
import sharipov.interfeign.FeignGif;

@Configuration
public class Config {
    @Bean
    public FeignClient feignClient() {
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(FeignClient.class, "https://openexchangerates.org/api");
    }

    @Bean
    public FeignGif feignGif() {
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(FeignGif.class, "https://api.giphy.com/v1/gifs/random");
    }
}
