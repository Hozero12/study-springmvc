package hello.springmvc.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Slf4j
public class RequestBodyJsonController {

    private ObjectMapper objectMapper = new ObjectMapper();

    @ResponseBody
    @PostMapping("/request-body-json-v3")
    public String requestBodyJsonV3(@RequestBody HelloData hellodata){

        log.info("username={},age={}", hellodata.getUsername(), hellodata.getAge());
        return "ok";

    }

    @ResponseBody
    @PostMapping("/request-body-json-v4")
    public String requestBodyJsonV4(@RequestBody HelloData hellodata){

        log.info("username={},age={}", hellodata.getUsername(), hellodata.getAge());
        return "ok";

    }
    @ResponseBody
    @PostMapping("/request-body-json-v5")
    public HelloData requestBodyJsonV5(@RequestBody HelloData hellodata){

        log.info("username={},age={}", hellodata.getUsername(), hellodata.getAge());
        return hellodata;

    }

    @ResponseBody
    @PostMapping("/request-body-json-v5")
    public HelloData requestBodyJsonV6(HttpEntity<HelloData> httpEntity){

        HelloData data = httpEntity.getBody();
        log.info("username={},age={}", data.getUsername(), data.getAge());
        return data;
    }
}
