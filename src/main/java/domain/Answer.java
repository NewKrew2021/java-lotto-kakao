package domain;

public class Answer {

    public static final String DUPLICATE_NUMBER_ERROR_MESSAGE = "당첨 번호에 포함된 수가 있습니다.";
    private final Lotto answerLotto;
    private final LottoNumber bonusNumber;

    public Answer(Lotto answerLotto, int bonusNumber) {
        if(answerLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR_MESSAGE);
        }
        this.answerLotto = answerLotto;
        this.bonusNumber = LottoNumber.of(bonusNumber);
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

    public Lotto getAnswerLotto() {
        return answerLotto;
    }

}
