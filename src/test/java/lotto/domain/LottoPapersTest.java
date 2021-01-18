package lotto.domain;

import lotto.domain.strategies.ManuallyGeneratingStrategy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;


@DisplayName("LottoPapers 클래스")
public class LottoPapersTest {
    LottoPaper testPaper1 = new LottoPaper(
            new ManuallyGeneratingStrategy(
                    new ArrayList<>(
                            Arrays.asList(
                                    new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                    new HashSet<>(Arrays.asList(7, 8, 9, 10, 11, 12)),
                                    new HashSet<>(Arrays.asList(13, 14, 15, 16, 17, 18)),
                                    new HashSet<>(Arrays.asList(19, 20, 21, 22, 23, 24))
                            )
                    )
            )
    );

    LottoPaper testPaper2 = new LottoPaper(
            new ManuallyGeneratingStrategy(
                    new ArrayList<>(
                            Arrays.asList(
                                    new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                    new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 8)),
                                    new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 36)),
                                    new HashSet<>(Arrays.asList(1, 2, 3, 4, 35, 36)),
                                    new HashSet<>(Arrays.asList(1, 2, 3, 34, 35, 36)),
                                    new HashSet<>(Arrays.asList(1, 2, 33, 34, 35, 36)),
                                    new HashSet<>(Arrays.asList(1, 32, 33, 34, 35, 36)),
                                    new HashSet<>(Arrays.asList(31, 32, 33, 34, 35, 36))
                            )
                    )
            )
    );

    LottoPaper testMergedPaper = new LottoPaper(
            new ManuallyGeneratingStrategy(
                    new ArrayList<>(
                            Arrays.asList(
                                    new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                    new HashSet<>(Arrays.asList(7, 8, 9, 10, 11, 12)),
                                    new HashSet<>(Arrays.asList(13, 14, 15, 16, 17, 18)),
                                    new HashSet<>(Arrays.asList(19, 20, 21, 22, 23, 24)),
                                    new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                    new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 8)),
                                    new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 36)),
                                    new HashSet<>(Arrays.asList(1, 2, 3, 4, 35, 36)),
                                    new HashSet<>(Arrays.asList(1, 2, 3, 34, 35, 36)),
                                    new HashSet<>(Arrays.asList(1, 2, 33, 34, 35, 36)),
                                    new HashSet<>(Arrays.asList(1, 32, 33, 34, 35, 36)),
                                    new HashSet<>(Arrays.asList(31, 32, 33, 34, 35, 36))
                            )
                    )
            )
    );

    @DisplayName("create test")
    @Test
    public void createTest() {
        Assertions.assertThatCode(() -> new LottoPapers()).doesNotThrowAnyException();
    }

    @DisplayName("paper 를 여러개 추가하고, 병합하는 기능 테스트")
    @Test
    public void addAndMergeTest() {
        //given;
        LottoPapers testLottoPapers = new LottoPapers();

        //when
        testLottoPapers.add(testPaper1);
        testLottoPapers.add(testPaper2);
        LottoPaper mergedPaper = testLottoPapers.getMergedPaper();

        //then
        assertThat(mergedPaper.getLottoNumberData()).isEqualTo(testMergedPaper.getLottoNumberData());
    }
}
