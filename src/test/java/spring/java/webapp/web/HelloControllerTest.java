package spring.java.webapp.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello")).andExpect(status().isOk()).andExpect(content().string(hello));

    }

}

/*
 * 1. @RunWith(SpirngRunner.class) - 테스트를 진행 할 때 JUnit에 내장된 실행자 외에 다른 실행자를 실행 -
 * 여기서는 SpringRunner라는 실행자를 사용 - 스프링 부트 테스트와 JUnit 사이에 연결자 역할을 함. 2. @WebMvcTest
 * - 스프링 테스트 어노테이션 중, Web(Spring MVC)에 집중할 수 있는 어노테이션 - 선언할
 * 경우 @Controller, @ControllerAdvice 등을 사용할 수 있음 -
 * 단, @Service, @Component, @Repository 등은 사용 불가능 - 여기서는 컨트롤러만 사용하기 때문에 선언했음. 3.
 * private MockMvc - 웹 API를 테스트할 때 사용 - 스프링 MVC 테스트의 시작점 - 이 클래스를 통해 GET,POST 등에
 * 대한 API 테스트를 할 수 있음. 4. mvc.perform(get("/hello")) - MockMvc를 통해 /hello 주소로
 * GET 요청을 함. - 체이닝이 지원되어 여러 검증 기능을 이어서 선언 할 수 있음. 4.1
 * andExpect(status().isOk()) - mvc.perform의 결과를 검증 - HTTP Header의 Status를 검증 -
 * 200,404,500 등의 상태를 검증할 수 있음 - 여기서는 isOK() 코드를 적었으므로 200인지 아닌지를 검증하는 것임 4.2
 * andExpect(content.string(hello)) - 응답 본문의 내용을 검증 - Controller에서 "hello"를 리턴하기
 * 때문에 이 값이 맞는지 검증함.
 * 
 */
