package domain;

public class Answer {

    private final Lotto answerLotto;
    private final LottoNumber bonusNumber;

    public Answer(Lotto answerLotto, int bonusNumber) {
        this.answerLotto = answerLotto;
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

    public Lotto getAnswerLotto() {
        return answerLotto;
    }

}
