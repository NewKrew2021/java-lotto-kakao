package lottomission.domain;

import lottomission.domain.exception.InvalidMoneyException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserMoneyTest {

    @Test
    public void 가능횟수_테스트(){
        UserMoney userMoney = new UserMoney(4500);
        assertThat(userMoney.getPossibleCount()).isEqualTo(4);
    }

    @Test
    public void 유저머니_에러_테스트(){
        assertThatThrownBy(() ->
                new UserMoney(-1000)
        ).isInstanceOf(InvalidMoneyException.class);
    }
}
