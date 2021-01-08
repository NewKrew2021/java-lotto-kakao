package lotto.domain.ranking;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoBonusApplicableTest {

    @DisplayName("보너스 번호가 포함되어있다면(참이라면) 로또 보너스에 적용되는지 여부를 판단한다.")
    @Test
    void applyTrue() {
        //given
        boolean bonus = true;

        //when
        boolean resultTrue = LottoBonusApplicable.TRUE.apply(bonus);
        boolean resultFalse = LottoBonusApplicable.FALSE.apply(bonus);
        boolean resultDontCare = LottoBonusApplicable.DONT_CARE.apply(bonus);

        //then
        assertAll(
                () -> assertThat(resultTrue).isTrue(),
                () -> assertThat(resultFalse).isFalse(),
                () -> assertThat(resultDontCare).isTrue()
        );
    }

    @DisplayName("보너스 번호가 포함되어있지 않다면(거짓이라면) 로또 보너스에 적용되는지 여부를 판단한다.")
    @Test
    void applyFalse() {
        //given
        boolean bonus = false;

        //when
        boolean resultTrue = LottoBonusApplicable.TRUE.apply(bonus);
        boolean resultFalse = LottoBonusApplicable.FALSE.apply(bonus);
        boolean resultDontCare = LottoBonusApplicable.DONT_CARE.apply(bonus);

        //then
        assertAll(
                () -> assertThat(resultTrue).isFalse(),
                () -> assertThat(resultFalse).isTrue(),
                () -> assertThat(resultDontCare).isTrue()
        );
    }
}
