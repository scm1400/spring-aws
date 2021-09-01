package spring.java.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Application {
    public static void main(String[] args) {

        // 내장 WAS(Tomcat)를 실행하는 코드
        SpringApplication.run(Application.class, args);

        // 스프링부트에서 내장 WAS를 사용하는 것을 권장
        // 이유: 언제 어디서나 같은 환경에서 스프링 부트를 배포 할 수 있기 때문
        // 외장 WAS를 사용하면 모든 서버는 WAS의 종류와 버전, 설정을 일치시켜야만 하는 불편함이 있음

    }

}