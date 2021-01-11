package mission.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserMoneyTest {

    @Test
    @DisplayName("UserMoney 객체 정상 생성 테스트")
    public void userMoneyCreateTest() {
        UserMoney userMoney = new UserMoney(10000);
        assertThat(userMoney.getUserMoney()).isEqualTo(10000);
    }

    @Test
    @DisplayName("UserMoney 객체 예외 테스트")
    public void userMoneyExceptionTest() {
        assertThatThrownBy(() -> new UserMoney(-10000))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new UserMoney(0))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
