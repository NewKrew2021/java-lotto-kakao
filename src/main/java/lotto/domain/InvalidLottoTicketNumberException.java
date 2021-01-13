package lotto.domain;

public class InvalidLottoTicketNumberException extends RuntimeException {
    private static final String INVALID_NUMBER_COUNT = "로또에 들어가야할 숫자는 중복없이 6개여야합니다.";

    public InvalidLottoTicketNumberException(){
        super(INVALID_NUMBER_COUNT);
    }
}
