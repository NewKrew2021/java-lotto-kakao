package lotto;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.LottoNumber.MAX_LOTTO_NUMBER;
import static lotto.LottoNumber.MIN_LOTTO_NUMBER;

public class Lotto {
    private static final int LOTTO_NUMBER_COUNT = 6;
    static final int LOTTO_PRICE = 1000;

    private final List<LottoNumber> lottoNumbers = new ArrayList<>();

    private Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers.forEach(num ->
                lottoNumbers.add(LottoNumber.getInstance(num))
        );
    }

    public static Lotto generateRandomLotto() {
        return new Lotto(generateLottoNumbers());
    }

    public static Lotto generateLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    public LottoResult checkLotto(Lotto winningLotto, LottoNumber bonusNumber) {
        return LottoResult.getResult(
                countSameLottoNumber(winningLotto),
                contains(bonusNumber)
        );
    }

    private int countSameLottoNumber(Lotto lotto) {
        Set<LottoNumber> set = new HashSet<>();

        for (int i = 0; i < LOTTO_NUMBER_COUNT; i++) {
            set.add(this.lottoNumbers.get(i));
            set.add(lotto.lottoNumbers.get(i));
        }

        return LOTTO_NUMBER_COUNT * 2 - set.size();
    }

    private boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    @Override
    public String toString() {
        return lottoNumbers.stream()
                .map(lotto -> String.valueOf(lotto.getNumber()))
                .collect(Collectors.joining(", "));
    }

    private static List<Integer> generateLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            lottoNumbers.add(i);
        }

        Collections.shuffle(lottoNumbers);
        List<Integer> sixLottoNumbers = lottoNumbers.subList(0, LOTTO_NUMBER_COUNT);
        Collections.sort(sixLottoNumbers);

        return sixLottoNumbers;
    }
}

