package spring.java.webapp.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// ⚡@RestController: 컨트롤러를 JSON 반환하는 컨트롤러로 만들어 줌
// ⚡@GetMapping: Get 요청을 받을 수 있는 API를 만들어 줌
//    - 예전에는 @RequestMapping(method = RequestMethod.GET) 이렇게 사용되던 것을 GetMapping으로 사용함
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

}
