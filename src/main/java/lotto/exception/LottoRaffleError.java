package lotto.exception;

public class LottoRaffleError extends RuntimeException {
    public LottoRaffleError() {
        super("로또 추첨이 잘못되었습니다.");
    }
}
