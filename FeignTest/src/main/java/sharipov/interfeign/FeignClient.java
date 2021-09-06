package sharipov.interfeign;

import feign.Param;
import feign.RequestLine;
import sharipov.entityes.RatesResponse;
import sharipov.entityes.RatesYesterdayResponse;

import java.time.LocalDate;

public interface FeignClient {

    @RequestLine("GET /latest.json?app_id={id}")
    RatesResponse getRates(@Param("id") String appId);

    @RequestLine("GET /historical/{date}.json?app_id={id}")
    RatesYesterdayResponse getRatesYesterday(@Param("date") LocalDate date, @Param("id") String appId);

}
