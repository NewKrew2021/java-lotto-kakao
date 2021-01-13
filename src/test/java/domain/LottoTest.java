package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTest {
    private Lotto lotto;
    private WinningLotto winningLotto;

    @BeforeEach
    public void setUpLotto() {
        lotto = new Lotto(getLottoBalls(1, 7, 8, 9, 10, 11));
        winningLotto = new WinningLotto(getLottoBalls(1, 2, 3, 4, 5, 6), 12);
    }

    @RepeatedTest(100)
    public void generateLottoTest() {
        Lotto randomLotto = Lotto.makeAutoLotto();
        List<Ball> lottoNumbers = randomLotto.getLottoBalls();
        assertThat(lottoNumbers.size()).isEqualTo(Lotto.LOTTO_COUNT);
        for (Object lottoNumber : lottoNumbers) {
            assertThat(Collections.frequency(lottoNumbers, lottoNumber)).isEqualTo(1);
        }
    }

    @Test
    @DisplayName("생성자 파라미터에 볼의 갯수가 6개가 아닐 때, 중복되는 숫자가 있을 때 테스트")
    void validator() {
        assertThatThrownBy(() -> {
            new Lotto(getLottoBalls(1, 7, 8, 9, 10));
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            new Lotto(getLottoBalls(1, 7, 8, 9, 10, 14, 15));
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            new Lotto(getLottoBalls(1, 7, 8, 9, 10, 10));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    public static List<Ball> getLottoBalls(int... numbers) {
        List<Ball> balls = new ArrayList<>();
        for (int number : numbers) {
            balls.add(new Ball(number));
        }
        return balls;
    }


}
