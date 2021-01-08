package lotto.dto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberDataTest {

    @Test
    public void getNumberDataTest(){

        List<Set<Integer>> testNumberData = Arrays.asList(
                new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6))
        );

        LottoNumberData lottoNumberData = new LottoNumberData(testNumberData);
        assertThat(lottoNumberData.getNumberData()).isEqualTo(testNumberData);
    }
}
