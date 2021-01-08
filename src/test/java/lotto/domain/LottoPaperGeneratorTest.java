package lotto.domain;

import lotto.dto.LottoNumberData;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPaperGeneratorTest {

    @Test
    public void generateManuallyTest() {
        LottoPaperGenerator generator = new LottoPaperGenerator(14000);

        LottoNumberData manualNumber = new LottoNumberData(
                Arrays.asList(
                        new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                        new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                        new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6))
                )
        );

        LottoPaper purchasedPaper = generator.generateManually(manualNumber);
        assertThat(purchasedPaper.getLottoNumberData()).isEqualTo(manualNumber);
    }
}