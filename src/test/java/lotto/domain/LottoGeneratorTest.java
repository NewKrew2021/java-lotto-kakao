package lotto.domain;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class LottoGeneratorTest {

    private LottoGenerator lottoGenerator;


    @BeforeEach
    public void setUp() {
        lottoGenerator = new LottoGenerator();

    }

    @Test
    @DisplayName("서로다른 번호 6개로 로또번호가 생성된것인지 확인")
    public void testLottoSize() {

        Lotto lotto = lottoGenerator.generateLotto();
        Assertions.assertTrue(lotto.getLotto().size()==6);

        HashSet<Integer> set = new HashSet<>();
        set.addAll(lotto.getLotto());
        Assertions.assertTrue(set.size()==6);
    }


}
