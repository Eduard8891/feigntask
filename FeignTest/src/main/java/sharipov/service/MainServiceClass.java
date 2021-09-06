package sharipov.service;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import sharipov.interfeign.FeignClient;
import sharipov.interfeign.FeignGif;

import java.time.LocalDate;


@Service
public class MainServiceClass {
    @Autowired
    FeignClient feignClient;
    @Autowired
    FeignGif feignGif;

    public String getRates(){
        String appId = "29f8165cd5024fa69e43126f40e75b2a";
        String apiKey = "iXSjtDvvP4pAsj4uTit0KAwYrweUzowu";
        double nowRate = Double.parseDouble(feignClient.getRates(appId).getValue());
        LocalDate yesterdayDate = LocalDate.now().minusDays(1);
        double yesterdayRate = Double.parseDouble(feignClient.getRatesYesterday(yesterdayDate, appId).getValue());

        String result = "";
        if (nowRate > yesterdayRate) {
            result = feignGif.getGif(apiKey, "rich").getGifUrl().getUrl();
        }
        else{
            result = feignGif.getGif(apiKey, "broke").getGifUrl().getUrl();
        }
        return String.format("<iframe src=\"%s\" </iframe>", result);
    }
}
