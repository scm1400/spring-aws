package spring.java.webapp.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import spring.java.webapp.config.auth.SecurityConfig;

// @RunWith(SpringRunner.class)
// @SpringBootTest
@ExtendWith({ SpringExtension.class })
@WebMvcTest(controllers = HelloController.class, excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = SecurityConfig.class)})
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @WithMockUser(roles = "USER")
    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello")).andExpect(status().isOk()).andExpect(content().string(hello));

    }

    @WithMockUser(roles = "USER")
    @Test
    public void helloDto가_리턴() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto").param("name", name).param("amount", String.valueOf(amount)))
                .andExpect(status().isOk()).andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
    // param
    // - API 테스트를 할 때 사용될 요청 파라미터를 설정
    // - String 값만 가능하기 때문에 int값인 amount를 불러올 때 String.valueOf 를 사용해 가져왔음

    // jsonPath
    // - JSON 응답값을 필드별로 검증할 수 있는 메소드
    // - $를 기준으로 필드명을 명시
    // - 여기서는 name과 amount를 검증하니 $.name, $.amount임

}

// 1. @RunWith(SpirngRunner.class)
// - 테스트를 진행 할 때 JUnit에 내장된 실행자 외에 다른 실행자를 실행
// - 여기서는 SpringRunner라는 실행자를 사용
// - 스프링 부트 테스트와 JUnit 사이에 연결자 역할을 함.
// 2. @WebMvcTest
// - 스프링 테스트 어노테이션 중, Web(Spring MVC)에 집중할 수 있는 어노테이션
// - 선언할 경우 @Controller, @ControllerAdvice 등을 사용할 수 있음
// 단, @Service, @Component, @Repository 등은 사용 불가능 - 여기서는 컨트롤러만 사용하기 때문에 선언했음.
// 3. private MockMvc
// - 웹 API를 테스트할 때 사용
// - 스프링 MVC 테스트의 시작점
// - 이 클래스를 통해 GET,POST 등에 대한 API 테스트를 할 수 있음.
// 4. mvc.perform(get("/hello"))
// - MockMvc를 통해 /hello 주소로 GET 요청을 함.
// - 체이닝이 지원되어 여러 검증 기능을 이어서 선언 할 수 있음.
// 4.1 andExpect(status().isOk())
// - mvc.perform의 결과를 검증
// - HTTP Header의 Status를 검증
// - 200,404,500 등의 상태를 검증할 수 있음
// - 여기서는 isOK() 코드를 적었으므로 200인지 아닌지를 검증하는 것임
// 4.2 andExpect(content.string(hello))
// - 응답 본문의 내용을 검증
// - Controller에서 "hello"를 리턴하기 때문에 이 값이 맞는지 검증함.
