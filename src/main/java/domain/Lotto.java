package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public LottoStatus getResult(Answer answer) {
        return LottoStatus.findStatus(countMatchingNumber(answer.getAnswerNumbers()), isBonusNumberMatching(answer.getBonusNumber()));
    }

    private boolean isBonusNumberMatching(int bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    private int countMatchingNumber(List<Integer> answerNumbers) {
        return lottoNumbers.stream().filter(number -> answerNumbers.contains(number)).collect(Collectors.toList()).size();
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        stringBuffer.append(lottoNumbers.stream().map(Object::toString).collect(Collectors.joining(",")));
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

}
