package domain;

import domain.LottoNumberMaker;
import domain.LottoStrategy;
import domain.RandomLottoStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
        LottoStrategy lottoStrategy = () -> Arrays.asList(1,2,3,4,5,6);
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

    @Test
    void StringSplitInvalidStringExceptionTest() {
        List<String> list = new ArrayList<>(Arrays.asList("abcd","efg"));
        LottoNumberMaker lottoNumberMaker = new LottoNumberMaker();
        assertThatThrownBy(()->{
            lottoNumberMaker.makeLottoNumberFromStrings(list);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("숫자가 아닙니다.");
    }

    @Test
    void StringToIntegerMappingTest() {
        List<String> list = new ArrayList<>(Arrays.asList("1","2","3"));
        assertThat(lottoNumberMaker.makeLottoNumberFromStrings(list)).containsExactly(1,2,3);
    }
}
