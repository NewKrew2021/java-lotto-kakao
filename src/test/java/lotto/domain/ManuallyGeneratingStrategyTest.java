package lotto.domain;

import lotto.domain.strategies.ManuallyGeneratingStrategy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


@DisplayName("ManuallyGeneratingStrategy 클래스")
public class ManuallyGeneratingStrategyTest {
    List<Set<Integer>> testInputNumberSets =
            new ArrayList<>(
                    Arrays.asList(
                            new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                            new HashSet<>(Arrays.asList(7, 8, 9, 10, 11, 12)),
                            new HashSet<>(Arrays.asList(13, 14, 15, 16, 17, 18)),
                            new HashSet<>(Arrays.asList(19, 20, 21, 22, 23, 24))
                    )
            );

    @DisplayName("객체 생성 테스트")
    @Test
    public void create() {
        Assertions.assertThatCode(
                () -> new ManuallyGeneratingStrategy(testInputNumberSets)
        ).doesNotThrowAnyException();
    }

    @DisplayName("generate를 정상횟수만큼 실행하였을때, original과 같은지 테스트한다.")
    @Test
    public void generateTest() {
        ManuallyGeneratingStrategy strategy = new ManuallyGeneratingStrategy(testInputNumberSets);
        List<Set<Integer>> outputNumberSets = new ArrayList<>();

        for(int i = 0; i < testInputNumberSets.size(); i++){
            outputNumberSets.add(strategy.generate());
        }

        assertThat(outputNumberSets).isEqualTo(testInputNumberSets);
    }

    @DisplayName("generate를 주어진 입력보다 많이 실행하였을때 예외가 발생하는지 테스트한다.")
    @Test
    public void IllegalGenerateTest() {
        ManuallyGeneratingStrategy strategy = new ManuallyGeneratingStrategy(testInputNumberSets);

        for(int i = 0; i < testInputNumberSets.size(); i++){
            strategy.generate();
        }

        assertThatExceptionOfType(ArrayIndexOutOfBoundsException.class)
                .isThrownBy(
                        strategy::generate
                ).withMessageMatching("입력보다 더 많이 generate했습니다.");
    }

    @DisplayName("generate를 할 수 있는 limit count를 확인한다.")
    @Test
    public void getLimitTest() {
        ManuallyGeneratingStrategy strategy = new ManuallyGeneratingStrategy(testInputNumberSets);
        assertThat(strategy.getLimit()).isEqualTo(testInputNumberSets.size());
    }
}
