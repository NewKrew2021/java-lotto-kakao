package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoTest {
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto("1,2,3,4,5,6");
    }

    @Test
    public void testLottoSizeException() {
        List<LottoNumber> smallLotto = Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5));
        List<LottoNumber> bigLotto = Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6), LottoNumber.of(7));
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new Lotto(smallLotto));
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new Lotto(bigLotto));
    }

    @Test
    @DisplayName("문자열로 로또 생성시 validation")
    public void testLottoMadeByStringSizeException() {
        String smallLotto = "1,2,3,4,5";
        String bigLotto = "1,2,3,4,5,6,7";
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new Lotto(smallLotto));
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new Lotto(bigLotto));
    }

    @Test
    @DisplayName("동일 번호입력시 에러 발생")
    public void testDuplicateLottoNumberException() {
        String duplicateLotto = "1,2,3,4,5,5";
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new Lotto(duplicateLotto));
    }

    @Test
    @DisplayName("문자열 입력이 제대로 파싱되었는지 확인")
    public void testLottoStringParser() {
        Lotto lotto = new Lotto("1,2,3,4,5,6");
        List<LottoNumber> userLottoNumber = Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6));
        Lotto userLotto = new Lotto(userLottoNumber);
        Assertions.assertTrue(lotto.checkSameCount(userLotto) == 6);
    }


    @Test
    public void testSameCountZero() {
        Lotto userLotto = new Lotto("12,13,14,15,16,17");
        Assertions.assertTrue(lotto.checkSameCount(userLotto) == 0);
    }

    @Test
    public void testSameCountOne() {
        Lotto userLotto = new Lotto("1,13,14,15,16,17");
        Assertions.assertTrue(lotto.checkSameCount(userLotto) == 1);
    }

    @Test
    public void testSameCountTwo() {
        Lotto userLotto = new Lotto("1,2,14,15,16,17");
        Assertions.assertTrue(lotto.checkSameCount(userLotto) == 2);
    }

    @Test
    public void testSameCountThree() {
        Lotto userLotto = new Lotto("1,2,3,15,16,17");
        Assertions.assertTrue(lotto.checkSameCount(userLotto) == 3);
    }

    @Test
    public void testSameCountFour() {
        Lotto userLotto = new Lotto("1,2,3,4,16,17");
        Assertions.assertTrue(lotto.checkSameCount(userLotto) == 4);
    }

    @Test
    public void testSameCountFive() {
        Lotto userLotto = new Lotto("1,2,3,4,5,17");
        Assertions.assertTrue(lotto.checkSameCount(userLotto) == 5);
    }

    @Test
    public void testSameCountSix() {
        Lotto userLotto = new Lotto("1,2,3,4,5,6");
        Assertions.assertTrue(lotto.checkSameCount(userLotto) == 6);
    }

    @Test
    public void testContain() {
        Assertions.assertTrue(lotto.contain(LottoNumber.of(1)));
        Assertions.assertFalse(lotto.contain(LottoNumber.of(13)));
    }
}
