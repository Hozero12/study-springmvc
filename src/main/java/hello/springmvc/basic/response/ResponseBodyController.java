package hello.springmvc.basic.response;

import hello.springmvc.basic.HelloData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResponseBodyController {


    @GetMapping("/response-body-ison-v1")
    public ResponseEntity<HelloData> responseBodyJsonV1 () {
        HelloData helloData = new HelloData();
        helloData.setUsername("user12");
        helloData.setAge(20);
        return new ResponseEntity(helloData, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/response-body-json-v2")
    public HelloData responseBodyJsonV2(){
        HelloData helloData = new HelloData();
        helloData.setUsername("user1");
        helloData.setAge(11);

        return helloData;
    }

}
