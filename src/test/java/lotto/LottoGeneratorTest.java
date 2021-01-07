package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {

    private LottoGenerator lottoGenerator;


    @BeforeEach
    public void setUp() {
        lottoGenerator = new LottoGenerator();

    }

    @Test
    public void testLottoSize() {

        Lotto lotto = lottoGenerator.generateLotto();
        Assertions.assertTrue(lotto.getLotto().size()==6);
    }


}
