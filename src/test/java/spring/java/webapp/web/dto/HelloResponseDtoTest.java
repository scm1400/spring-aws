package spring.java.webapp.web.dto;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

/*
Junit의 assertThat < assertj의 assertThat
Junit의 assertThat을 사용하면 is()와 같이 CoreMatchers 라이브러리가 필요한데, assertj는 필요없다.
assertj를 사용할 때 자동완성이 좀  더 확실하게 지원된다.
결론: junit의 assertThat 쓰지마라
*/

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트() {
        // given
        String name = "test";
        int amount = 1000;

        // when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        // then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);

    }
}
