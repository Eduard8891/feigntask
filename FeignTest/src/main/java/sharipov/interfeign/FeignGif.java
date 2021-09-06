package sharipov.interfeign;

import feign.Param;
import feign.RequestLine;
import sharipov.entityes.Gif;

public interface FeignGif {
    @RequestLine("GET ?api_key={id}&tag={tag}")
    Gif getGif(@Param("id") String apiKey, @Param("tag") String tag);
}
