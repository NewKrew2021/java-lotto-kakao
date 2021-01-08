package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class LottoNumbersTest {
    @Test
    void isEqualAndValid() {
        List<LottoNumber> ticket = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        List<LottoNumber> numbersWithDifferentOrder = Stream.of(6, 5, 4, 3, 2, 1)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        LottoNumbers lottoNumbers = new LottoNumbers(ticket);

        assertThat(lottoNumbers)
                .isEqualTo(new LottoNumbers(numbersWithDifferentOrder));
    }

    @Test
    void shouldNotBeEqual() {
        List<LottoNumber> originalNumbers = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        List<LottoNumber> differentNumbers = Stream.of(1, 2, 3, 4, 5, 7)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        LottoNumbers lottoNumbers = new LottoNumbers(originalNumbers);

        assertThat(lottoNumbers)
                .isNotEqualTo(new LottoNumbers(differentNumbers));
    }

    @ParameterizedTest
    @CsvSource({"1,true", "7,false"})
    void testContains(int number, boolean expected) {
        List<LottoNumber> ticket = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        assertThat(new LottoNumbers(ticket)
                .contains(new LottoNumber(number))).isEqualTo(expected);
    }

    @Test
    void duplicateNumbersShouldThrowError() {
        List<LottoNumber> ticket = Stream.of(1, 2, 3, 4, 5, 5)
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        assertThatThrownBy(() -> new LottoNumbers(ticket))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void fiveElementsShouldThrowError() {
        List<LottoNumber> ticket = Stream.of(1, 2, 3, 4, 5)
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        assertThatThrownBy(() -> new LottoNumbers(ticket))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
