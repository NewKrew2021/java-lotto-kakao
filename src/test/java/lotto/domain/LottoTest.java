package lotto.domain;

import lotto.service.LottoGeneratorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoTest {
    private Lotto lotto;
    private LottoGeneratorService lottoGeneratorService;

    @BeforeEach
    void setUp() {
        lottoGeneratorService = new LottoGeneratorService();
        lotto = lottoGeneratorService.lottoStringParser("1,2,3,4,5,6");
    }

    @Test
    public void testLottoSizeException() {
        List<LottoNumber> smallLotto = Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5));
        List<LottoNumber> bigLotto = Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6), LottoNumber.of(7));
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new Lotto(smallLotto));
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new Lotto(bigLotto));
    }

    @Test
    public void testSameCountZero() {
        Lotto userLotto = lottoGeneratorService.lottoStringParser("12,13,14,15,16,17");
        Assertions.assertTrue(lotto.checkSameCount(userLotto) == 0);
    }

    @Test
    public void testSameCountOne() {
        Lotto userLotto = lottoGeneratorService.lottoStringParser("1,13,14,15,16,17");
        Assertions.assertTrue(lotto.checkSameCount(userLotto) == 1);
    }

    @Test
    public void testSameCountTwo() {
        Lotto userLotto = lottoGeneratorService.lottoStringParser("1,2,14,15,16,17");
        Assertions.assertTrue(lotto.checkSameCount(userLotto) == 2);
    }

    @Test
    public void testSameCountThree() {
        Lotto userLotto = lottoGeneratorService.lottoStringParser("1,2,3,15,16,17");
        Assertions.assertTrue(lotto.checkSameCount(userLotto) == 3);
    }

    @Test
    public void testSameCountFour() {
        Lotto userLotto = lottoGeneratorService.lottoStringParser("1,2,3,4,16,17");
        Assertions.assertTrue(lotto.checkSameCount(userLotto) == 4);
    }

    @Test
    public void testSameCountFive() {
        Lotto userLotto = lottoGeneratorService.lottoStringParser("1,2,3,4,5,17");
        Assertions.assertTrue(lotto.checkSameCount(userLotto) == 5);
    }

    @Test
    public void testSameCountSix() {
        Lotto userLotto = lottoGeneratorService.lottoStringParser("1,2,3,4,5,6");
        Assertions.assertTrue(lotto.checkSameCount(userLotto) == 6);
    }

    @Test
    public void testContain() {
        Assertions.assertTrue(lotto.contain(LottoNumber.of(1)));
        Assertions.assertFalse(lotto.contain(LottoNumber.of(13)));
    }
}
