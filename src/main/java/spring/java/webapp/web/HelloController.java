package spring.java.webapp.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring.java.webapp.web.dto.HelloResponseDto;

// ⚡@RestController: 컨트롤러를 JSON 반환하는 컨트롤러로 만들어 줌
// ⚡@GetMapping: Get 요청을 받을 수 있는 API를 만들어 줌
//    - 예전에는 @RequestMapping(method = RequestMethod.GET) 이렇게 사용되던 것을 GetMapping으로 사용함
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }

}

// @RequestParam
// 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션
// 이 코드에서는 외부에서 name(@RequestParam("name"))이란 이름으로 넘긴 파라미터를 메소드 파라미터 name(String
// name)에 저장한다.