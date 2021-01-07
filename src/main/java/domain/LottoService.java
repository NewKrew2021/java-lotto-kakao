package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoService {

    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 45;

    private static final List<Integer> randomNumbers;

    static {
        randomNumbers = new ArrayList<>();
        for (int i = LOWER_BOUND; i <= UPPER_BOUND; i++) {
            randomNumbers.add(i);
        }
    }

    public static LottoTickets generateRandomLottoTickets(int ticketCount) {
        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            tickets.add(generateRandomLottoTicket());
        }

        return new LottoTickets(tickets);
    }

    private static LottoTicket generateRandomLottoTicket() {
        Collections.shuffle(randomNumbers);
        List<LottoNumber> numbers = new ArrayList<>();
        for (int i = 0; i < LottoTicket.LOTTO_NUMBERS_LENGTH; i++) {
            numbers.add(new LottoNumber(randomNumbers.get(i)));
        }
        Collections.sort(numbers);

        return LottoTicket.ofLottoNumber(numbers);
    }
}
