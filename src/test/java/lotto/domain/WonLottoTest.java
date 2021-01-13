package lotto.domain;

import lotto.service.LottoGeneratorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

public class WonLottoTest {
    private WonLotto wonLotto;
    private LottoGeneratorService lottoGeneratorService;

    @BeforeEach
    void setUp() {
        lottoGeneratorService=new LottoGeneratorService();
        wonLotto = new WonLotto(lottoGeneratorService.lottoStringParser("1,2,3,4,5,6"), LottoNumber.of(7));
    }

    @Test
    @DisplayName("서로다른 번호 7개로 당첨번호가 생성된것인지 확인")
    void testWonLottoSize() {
        HashSet<LottoNumber> set = new HashSet<>();
        set.addAll(wonLotto.getWonLotto().getLottoNumbers());
        Assertions.assertTrue(set.size() == 6);
        set.add(wonLotto.getBonusNo());
        Assertions.assertTrue(set.size() == 7);
    }

}
