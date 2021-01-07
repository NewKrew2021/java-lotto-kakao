import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoNumberMakerTest {

    private LottoNumberMaker lottoNumberMaker;

    @BeforeEach
    void setUp() {
        lottoNumberMaker = new LottoNumberMaker();
    }

    @Test
    void generateNumbersTest() {
        List<Integer> results = lottoNumberMaker.generateLottoNumbers(new RandomLottoStrategy());
        assertThat(results.size()).isEqualTo(6);
    }

    @Test
    void generateNumberContainsTest() {
        List<Integer> results;
        LottoStrategy lottoStrategy = new LottoStrategy() {
            @Override
            public List<Integer> NumberChoose() {
                return Arrays.asList(1,2,3,4,5,6);
            }
        };
        results = lottoNumberMaker.generateLottoNumbers(lottoStrategy);
        assertThat(results).containsExactly(1,2,3,4,5,6);
    }

    @RepeatedTest(100)
    void generateNumberRangeTest() {
        List<Integer> results = lottoNumberMaker.generateLottoNumbers(new RandomLottoStrategy());
        for (Integer result : results) {
            assertThat(result).isBetween(1,45);
        }

    }
}
