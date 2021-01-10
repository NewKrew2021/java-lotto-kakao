package domain;

import utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {

    public static final int LOTTO_NUMBER_SIZE = 6;
    private static final String LOTTO_SIZE_EXCEED_ERROR_MESSAGE = "%d개의 숫자를 입력해주세요.";

    private List<LottoNumber> lottoNumbers;



    public Lotto(LottoStrategy lottoStrategy) {
        List<Integer> numbers = lottoStrategy.numberChooseStrategy();

        if(numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(String.format(LOTTO_SIZE_EXCEED_ERROR_MESSAGE, LOTTO_NUMBER_SIZE));
        }

        lottoNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public LottoStatus getResult(Answer answer) {
        return LottoStatus.
                findStatus(countMatchingNumber(answer.getAnswerLotto()), isBonusNumberMatching(answer.getBonusNumber()));
    }

    private boolean isBonusNumberMatching(LottoNumber bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    private int countMatchingNumber(Lotto answerLotto) {
        return lottoNumbers.stream()
                .filter(number -> answerLotto.getLottoNumbers().contains(number))
                .collect(Collectors.toList()).size();
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");

        stringBuffer.append(lottoNumbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(",")));

        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
