package lottomission.domain;

public class LottoAnswer {

    private final LottoNumbers answerNumbers;
    private final LottoNumber bonusNumber;

    public LottoAnswer(LottoNumbers answerNumbers, LottoNumber bonusNumber) {
        if (answerNumbers.isContainLottoNumber(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호와 보너스 번호가 같을 수 없습니다.");
        }
        this.answerNumbers = answerNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int getMatchNumberCount(LottoNumbers numbers) {
        return LottoNumbers.MAX_NUMBERS_LENGTH * 2 - answerNumbers.getCombineSetLength(numbers);
    }

    public boolean isMatchBonusNumber(LottoNumbers numbers) {
        return numbers.getNumbers().contains(this.bonusNumber);
    }
}
