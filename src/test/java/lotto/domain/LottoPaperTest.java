package lotto.domain;

import lotto.domain.strategies.ManuallyGeneratingStrategy;
import lotto.dto.LottoNumberData;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("LottoPaper 클래스")
public class LottoPaperTest {
    List<Set<Integer>> testInputNumberSets =
            new ArrayList<>(
                    Arrays.asList(
                            new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                            new HashSet<>(Arrays.asList(7, 8, 9, 10, 11, 12)),
                            new HashSet<>(Arrays.asList(13, 14, 15, 16, 17, 18)),
                            new HashSet<>(Arrays.asList(19, 20, 21, 22, 23, 24))
                    )
            );

    LottoPaper testPaper;

    @BeforeEach
    public void testPaperCreate() {
        testPaper = new LottoPaper (
                new ManuallyGeneratingStrategy(
                        testInputNumberSets
                )
        );
    }

    @DisplayName("객체 생성 테스트")
    @Test
    public void createTest() {
        Assertions.assertThatCode(
                () -> {
                    new LottoPaper(
                            new ManuallyGeneratingStrategy(
                                    testInputNumberSets
                            )
                    );
                }
        ).doesNotThrowAnyException();
    }

    @DisplayName("두개의 LottoPaper 객체를 하나로 합치는 기능 테스트")
    @Test
    public void joinTest() {
        //given
        LottoPaper paper1 = new LottoPaper(new ManuallyGeneratingStrategy(testInputNumberSets));
        LottoPaper paper2 = new LottoPaper(new ManuallyGeneratingStrategy(testInputNumberSets));

        List<Set<Integer>> dataOfExpectedResult = new ArrayList<>();
        for(int i = 0; i < testInputNumberSets.size() * 2; i++) {
            Set<Integer> copiedTicketInfo = testInputNumberSets.get(i % testInputNumberSets.size());
            dataOfExpectedResult.add(copiedTicketInfo);
        }
        LottoNumberData expectedResult = new LottoNumberData(dataOfExpectedResult);

        //when
        LottoPaper joinedPaper = LottoPaper.join(paper1, paper2);
        LottoNumberData testResult = joinedPaper.getLottoNumberData();

        //then
        assertThat(testResult).isEqualTo(expectedResult);
    }

    @DisplayName("객체가 자신이 가지고 있는 정보를 바탕으로 적절한 LottoNumberData를 반환하는지 검사")
    @Test
    public void getLottoNumberDataTest() {
        LottoNumberData lottoNumberData = testPaper.getLottoNumberData();
        assertThat(lottoNumberData).isEqualTo(
                new LottoNumberData(testInputNumberSets)
        );
    }

    @DisplayName("paper객체로부터 LottoResult 객체를 생성하는 기능 테스트 #1")
    @Test
    public void getResultCompareWith_test_1_() {
        //given
        LottoPaper testPaper = new LottoPaper(
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

        WinnerBalls testWinnerBalls = new WinnerBalls(
                Arrays.asList(1, 2, 3, 4, 5, 6), 8
        );

        List<Rank> testRanks = Arrays.asList(
                Rank.FIRST, Rank.OUT, Rank.OUT, Rank.OUT
        );

        LottoResult expectedLottoResult = new LottoResult();
        for(Rank rank : testRanks) {
            expectedLottoResult.putRank(rank);
        }

        //when
        LottoResult testResult = testPaper.getResultCompareWith(testWinnerBalls);

        //then
        assertThat(testResult).isEqualTo(expectedLottoResult);
    }

    @DisplayName("paper객체로부터 LottoResult 객체를 생성하는 기능 테스트 #2")
    @Test
    public void getResultCompareWith_test_2_() {
        //given
        LottoPaper testPaper = new LottoPaper(
                new ManuallyGeneratingStrategy(
                        new ArrayList<>(
                                Arrays.asList(
                                        new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                        new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                        new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                        new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                        new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                        new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                        new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                        new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                        new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                        new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                        new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                        new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                        new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                        new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                        new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                        new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                        new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                        new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                        new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                        new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)) //20th
                                )
                        )
                )
        );

        WinnerBalls testWinnerBalls = new WinnerBalls(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                8
        );

        List<Rank> testRanks = Arrays.asList(
                Rank.FIRST, Rank.FIRST, Rank.FIRST, Rank.FIRST, Rank.FIRST,
                Rank.FIRST, Rank.FIRST, Rank.FIRST, Rank.FIRST, Rank.FIRST,
                Rank.FIRST, Rank.FIRST, Rank.FIRST, Rank.FIRST, Rank.FIRST,
                Rank.FIRST, Rank.FIRST, Rank.FIRST, Rank.FIRST, Rank.FIRST
        );

        LottoResult expectedLottoResult = new LottoResult();
        for(Rank rank : testRanks) {
            expectedLottoResult.putRank(rank);
        }

        //when
        LottoResult testResult = testPaper.getResultCompareWith(testWinnerBalls);

        //then
        assertThat(testResult).isEqualTo(expectedLottoResult);
    }

    @DisplayName("paper객체로부터 LottoResult 객체를 생성하는 기능 테스트 #3")
    @Test
    public void getResultCompareWith_test_3_() {
        //given
        LottoPaper testPaper = new LottoPaper(
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

        WinnerBalls testWinnerBalls = new WinnerBalls(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                8
        );

        List<Rank> testRanks = Arrays.asList(
                Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.FOURTH, Rank.FIFTH, Rank.OUT, Rank.OUT, Rank.OUT
        );

        LottoResult expectedLottoResult = new LottoResult();
        for(Rank rank : testRanks) {
            expectedLottoResult.putRank(rank);
        }

        //when
        LottoResult testResult = testPaper.getResultCompareWith(testWinnerBalls);

        //then
        assertThat(testResult).isEqualTo(expectedLottoResult);
    }

    @DisplayName("paper객체로부터 LottoResult 객체를 생성하는 기능 테스트 #4")
    @Test
    public void getResultCompareWith_test_4_() {
        //given
        LottoPaper testPaper = new LottoPaper(
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

        WinnerBalls testWinnerBalls = new WinnerBalls(
                Arrays.asList(40, 41, 42, 43, 44, 45),
                8
        );

        List<Rank> testRanks = Arrays.asList(
                Rank.OUT, Rank.OUT, Rank.OUT, Rank.OUT
        );

        LottoResult expectedLottoResult = new LottoResult();
        for(Rank rank : testRanks) {
            expectedLottoResult.putRank(rank);
        }

        //when
        LottoResult testResult = testPaper.getResultCompareWith(testWinnerBalls);

        //then
        assertThat(testResult).isEqualTo(expectedLottoResult);
    }
}