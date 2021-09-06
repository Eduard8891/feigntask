package sharipov;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sharipov.interfeign.FeignClient;
import sharipov.interfeign.FeignGif;
import sharipov.service.MainServiceClass;

import java.time.LocalDate;


@SpringBootTest
class FeignTestApplicationTests {
    String appId = "29f8165cd5024fa69e43126f40e75b2a";
    String apiKey = "iXSjtDvvP4pAsj4uTit0KAwYrweUzowu";
    @Autowired
    MainServiceClass mainServiceClass = Mockito.mock(MainServiceClass.class);
    @Autowired
    FeignClient feignClient;
    @Autowired
    FeignGif feignGif;


    @Test
    public void responseDifferentRates() {
        double now = Double.parseDouble(feignClient.getRates(appId).getValue());
        double yes = Double.parseDouble(feignClient.getRatesYesterday(LocalDate.now().minusDays(1), appId).getValue());
        Assertions.assertNotEquals(now, yes);
    }
    @Test
    public void responseGif() {
        String url = feignGif.getGif(apiKey, "rich").getGifUrl().getUrl();
        Assertions.assertTrue(url.contains("https://giphy.com"));
        }

}

