package thigns.ui;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {

    @GetMapping("/hello")
    public String hello() {
        /*log.info("requestId = {}", MDC.get("requestId"));
        log.info("requestUrl = {}", MDC.get("requestUrl"));
        log.info("userAgent = {}", MDC.get("userAgent"));
        log.info("clientIP = {}", MDC.get("clientIP"));*/
        log.info("hello");

        return "ok";
    }
}
