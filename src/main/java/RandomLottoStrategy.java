import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoStrategy implements LottoStrategy{

    private static final int END_LOTTO_NUMBER = 45;
    private static final int START_LOTTO_NUMBER = 1;
    private static final int LOTTO_NUMBER_SIZE = 6;

    private List<Integer> LottoNumbers;

    public RandomLottoStrategy() {
        this.LottoNumbers = IntStream.rangeClosed(START_LOTTO_NUMBER, END_LOTTO_NUMBER).
                boxed().collect(Collectors.toList());
    }

    @Override
    public List<Integer> NumberChoose() {
        Collections.shuffle(LottoNumbers);

        return LottoNumbers.stream().limit(LOTTO_NUMBER_SIZE).collect(Collectors.toList());
    }

}
