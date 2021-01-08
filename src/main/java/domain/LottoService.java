package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoService {

    private static final List<Integer> randomNumbers;

    static {
        randomNumbers = new ArrayList<>();
        for (int i = LottoNumber.LOWER_BOUND; i <= LottoNumber.UPPER_BOUND; i++) {
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
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < LottoTicket.LOTTO_NUMBERS_LENGTH; i++) {
            numbers.add((randomNumbers.get(i)));
        }
        Collections.sort(numbers);

        return new LottoTicket(numbers);
    }
}
