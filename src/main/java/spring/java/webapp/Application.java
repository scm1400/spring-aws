/*
안좋은 예시
1. 코드 작성
2. 프로그램(Tomcat) 실행
3. Postman과 같은 API 테스트 도구로 HTTP 요청
4. 요청 결과를 System.out.println()
5. 결과가 다르면 다시 프로그램(Tomcat)을 중지하고 코드를 수정
*/

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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