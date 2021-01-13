package lotto;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.LottoNumber.MAX_LOTTO_NUMBER;
import static lotto.LottoNumber.MIN_LOTTO_NUMBER;

public class Lotto {
    private static final int LOTTO_NUMBERS_COUNT = 6;
    public static final int LOTTO_PRICE = 1000;

    private final List<LottoNumber> lottoNumbers = new ArrayList<>();

    private Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers.forEach(num ->
                lottoNumbers.add(LottoNumber.of(num))
        );
    }

    public static Lotto generateRandomLotto() {
        return new Lotto(generateLottoNumbers());
    }

    public static Lotto generateManualLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateCount(numbers);
        validateDuplicate(numbers);
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException("Input numbers exceed " + LOTTO_NUMBERS_COUNT + ".");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<Integer>();

        for (Integer number : numbers) {
            numberSet.add(number);
        }

        if (numberSet.size() != LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException("Input numbers contains duplicate numbers.");
        }
    }

    public LottoResult checkLotto(Lotto winningLotto, LottoNumber bonusNumber) {
        return LottoResult.getResult(
                countSameLottoNumber(winningLotto),
                contains(bonusNumber)
        );
    }

    private int countSameLottoNumber(Lotto lotto) {
        Set<LottoNumber> set1 = new HashSet<>();
        Set<LottoNumber> set2 = new HashSet<>();

        for (int i = 0; i < LOTTO_NUMBERS_COUNT; i++) {
            set1.add(this.lottoNumbers.get(i));
            set2.add(lotto.lottoNumbers.get(i));
        }
        set1.retainAll(set2);

        return set1.size();
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
        List<Integer> sixLottoNumbers = lottoNumbers.subList(0, LOTTO_NUMBERS_COUNT);
        Collections.sort(sixLottoNumbers);

        return sixLottoNumbers;
    }
}

