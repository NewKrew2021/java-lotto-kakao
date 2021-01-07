package lotto.util;

import java.util.Arrays;
import java.util.List;

public class FixNumberGenerator implements LottoNumberGenerator {
    @Override
    public List<Integer> getNumbers() {
        return Arrays.asList(1, 2, 3, 4, 5, 7);
    }
}
