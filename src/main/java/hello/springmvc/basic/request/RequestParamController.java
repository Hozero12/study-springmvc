package hello.springmvc.basic.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        log.info("username={}, age={}", username, age);

        response.getWriter().write("ok");
    }

    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge){

        log.info("username={}, age={}", memberName, memberAge);
        return "ok";

    }

    @ResponseBody
    @RequestMapping("/request-param-v3")  //요청 파라미터 이름과 같을경우 RequestParam name 생략 가능
    public String requestParamV3(
            @RequestParam String username,
            @RequestParam int age ){

        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v4")  //단순 타입이면 @RepuestParam 도 생략 가능
    public String requestParamV4(String username, int age ){

        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-required")  //  username 이라는 파라미터가 없으면 값이 null, 파라미터는 있지만 값이 없으면 "" 반값으로 나옴 // php에서 empty, isset
    public String requestParamV5(
            @RequestParam(required = true) String username,
            @RequestParam(required = false) Integer age ){

        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-defaultValue")  //  username이 빈값 '/?username=' 으로 들어와도 defaultValue 작동함
    public String requestParamV6(
            @RequestParam(required = true, defaultValue = "guest") String username,
            @RequestParam(required = false, defaultValue = "-1") int age ){

        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-map")  //  username이 빈값 '/?username=' 으로 들어와도 defaultValue 작동함
    public String requestParamMap(@RequestParam Map<String, Object> param){

        log.info("username={}, age={}", param.get("username"), param.get("age"));
        return "ok";
    }
}
