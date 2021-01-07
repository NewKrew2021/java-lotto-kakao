package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumbersTest {
    @Test
    public void testNumberCount() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Set<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
            new LottoNumbers(numbers);
        }).withMessageMatching("로또 번호는 6개의 숫자여야 합니다.");
        ;
    }

    @Test
    public void testNumberRange() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Set<Integer> numbers = new HashSet<>(Arrays.asList(0, 2, 3, 4, 5, 49));
            new LottoNumbers(numbers);
        }).withMessageMatching("로또 번호는 1부터 45까지의 숫자 중 하나여야 합니다.");
        ;
    }
}
