package lotto.exception;

public class InvalidLotteryNumberException extends IllegalArgumentException {

    private static final String MSG_WRONG_LOTTERYNUMBER_RANGE = "로또 번호는 1와 45 사이의 수여야 합니다.";

    public InvalidLotteryNumberException() {
        this(MSG_WRONG_LOTTERYNUMBER_RANGE);
    }

    public InvalidLotteryNumberException(String message) {
        super(message);
    }
}
