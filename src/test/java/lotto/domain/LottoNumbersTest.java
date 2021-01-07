package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
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
    public void testValidateNumberRange() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Set<Integer> numbers = new HashSet<>(Arrays.asList(0, 2, 3, 4, 5, 49));
            new LottoNumbers(numbers);
        }).withMessageMatching("로또 번호는 1부터 45까지의 숫자 중 하나여야 합니다.");
        ;
    }

    @Test
    public void testContains() {
        Set<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumbers lottoNumbers = new LottoNumbers(numbers);
        assertThat(lottoNumbers.contains(6)).isTrue();
        assertThat(lottoNumbers.contains(7)).isFalse();
    }

    @Test
    public void testCountIntersection() {
        Set<Integer> baseNumbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumbers baseLottoNumbers = new LottoNumbers(baseNumbers);
        Set<Integer> comparisionNumbers = new HashSet<>(Arrays.asList(7, 8, 9, 4, 5, 6));
        LottoNumbers comparisionLottoNumbers = new LottoNumbers(comparisionNumbers);
        assertThat(baseLottoNumbers.countIntersection(comparisionLottoNumbers)).isEqualTo(3);
    }
}
