package lotto.domain;

import lotto.dto.LottoNumberData;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

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
    public void testPaperCreate(){
        testPaper = new LottoPaper (
                new ManuallyGeneratingStrategy(
                        testInputNumberSets
                )
        );
    }

    @DisplayName("객체 생성 테스트")
    @Test
    public void createTest(){
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

    @DisplayName("객체가 자신이 가지고 있는 정보를 바탕으로 적절한 LottoNumberData를 반환하는지 검사")
    @Test
    public void getLottoNumberDataTest(){
        LottoNumberData lottoNumberData = testPaper.getLottoNumberData();
        assertThat(lottoNumberData).isEqualTo(
                new LottoNumberData(testInputNumberSets)
        );
    }

    @DisplayName("미리 준비해둔 Paper와 당첨정보 test case를 바탕으로 일치하는 결과가 나오는지 테스트")
    @ParameterizedTest
    @MethodSource("providePaperAndResult")
    public void getResultCompareWithTest(List<Set<Integer>> dataForPaper, WinnerBalls winnerBalls, List<Rank> lottoResult){
        LottoPaper testPaper = new LottoPaper(
                new ManuallyGeneratingStrategy(dataForPaper)
        );

        LottoResult expectedLottoResult = new LottoResult();
        for(Rank rank : lottoResult){
            expectedLottoResult.putRank(rank);
        }

        assertThat(testPaper.getResultCompareWith(winnerBalls)).isEqualTo(expectedLottoResult);
    }

    // 너무 코드가 길어져서 당황스럽지만,,, 그래도 이 부분을 테스트 하지 않고 넘어가면,
    // 나중에 에러가 발생했을때, 더 시간을 많이 쓸것 같아서 넣었습니다.
    private static Stream<Arguments> providePaperAndResult(){
        return Stream.of(

                /* test case #1 */
                Arguments.of
                        (  // 1. data for LottoPaper
                                new ArrayList<>(
                                        Arrays.asList(
                                                new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                                new HashSet<>(Arrays.asList(7, 8, 9, 10, 11, 12)),
                                                new HashSet<>(Arrays.asList(13, 14, 15, 16, 17, 18)),
                                                new HashSet<>(Arrays.asList(19, 20, 21, 22, 23, 24))
                                        )
                                )
                                ,
                                // 2. WinnerBalls class
                                new WinnerBalls(
                                        Arrays.asList(1, 2, 3, 4, 5, 6),
                                        8
                                )
                                ,
                                // 3. data for LottoResult
                                Arrays.asList(
                                        Rank.FIRST, Rank.OUT, Rank.OUT, Rank.OUT
                                )
                        ),

                /* test case #2 */
                Arguments.of
                        (  // 1. data for LottoPaper
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
                                ,
                                // 2. WinnerBalls class
                                new WinnerBalls(
                                        Arrays.asList(1, 2, 3, 4, 5, 6),
                                        8
                                )
                                ,
                                // 3. data for LottoResult
                                Arrays.asList(
                                        Rank.FIRST, Rank.FIRST, Rank.FIRST, Rank.FIRST, Rank.FIRST,
                                        Rank.FIRST, Rank.FIRST, Rank.FIRST, Rank.FIRST, Rank.FIRST,
                                        Rank.FIRST, Rank.FIRST, Rank.FIRST, Rank.FIRST, Rank.FIRST,
                                        Rank.FIRST, Rank.FIRST, Rank.FIRST, Rank.FIRST, Rank.FIRST
                                )
                        ),

                /* test case #3 */
                Arguments.of
                        (  // 1. data for LottoPaper
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
                                ,
                                // 2. WinnerBalls class
                                new WinnerBalls(
                                        Arrays.asList(1, 2, 3, 4, 5, 6),
                                        8
                                )
                                ,
                                // 3. data for LottoResult
                                Arrays.asList(
                                        Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.FOURTH, Rank.FIFTH, Rank.OUT, Rank.OUT, Rank.OUT
                                )
                        ),

                /* test case #4 */
                Arguments.of
                        (  // 1. data for LottoPaper
                                new ArrayList<>(
                                        Arrays.asList(
                                                new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                                new HashSet<>(Arrays.asList(7, 8, 9, 10, 11, 12)),
                                                new HashSet<>(Arrays.asList(13, 14, 15, 16, 17, 18)),
                                                new HashSet<>(Arrays.asList(19, 20, 21, 22, 23, 24))
                                        )
                                )
                                ,
                                // 2. WinnerBalls class
                                new WinnerBalls(
                                        Arrays.asList(40, 41, 42, 43, 44, 45),
                                        8
                                )
                                ,
                                // 3. data for LottoResult
                                Arrays.asList(
                                        Rank.OUT, Rank.OUT, Rank.OUT, Rank.OUT
                                )
                        )
        );
    }
}