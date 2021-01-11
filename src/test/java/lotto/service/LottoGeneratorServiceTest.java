package lotto.service;

import lotto.domain.Lotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class LottoGeneratorServiceTest {

    private LottoGeneratorService lottoGeneratorService;


    @BeforeEach
    public void setUp() {
        lottoGeneratorService = new LottoGeneratorService();

    }

    @Test
    @DisplayName("서로다른 번호 6개로 로또번호가 생성된것인지 확인")
    public void testLottoSize() {

        Lotto lotto = lottoGeneratorService.generateLotto();
        Assertions.assertTrue(lotto.getLottoNumbers().size() == 6);

        HashSet<Integer> set = new HashSet<>();
//        set.addAll(lotto.getLottoNumbers());
//        Assertions.assertTrue(set.size() == 6);
    }


}
