package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LottoGeneratorServiceTest {
    private LottoGeneratorService lottoGeneratorService;

    @BeforeEach
    public void setUp() {
        lottoGeneratorService = new LottoGeneratorService();
    }

    @Test
    @DisplayName("문자열 입력이 제대로 파싱되었는지 확인")
    public void testLottoStringParser() {
        Lotto lotto = lottoGeneratorService.lottoStringParser("1,2,3,4,5,6");
        List<LottoNumber> userLottoNumber = Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6));
        Lotto userLotto = new Lotto(userLottoNumber);
        Assertions.assertTrue(lotto.checkSameCount(userLotto) == 6);
    }

}
