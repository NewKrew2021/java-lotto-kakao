package domain;

public class Answer {

    private final Lotto answerLotto;
    private final LottoNumber bonusNumber;

    public Answer(Lotto answerLotto, int bonusNumber) {
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
