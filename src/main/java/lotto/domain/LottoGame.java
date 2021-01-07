package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static final int TICKET_PRICE = 1000;
    private LottoTickets tickets;

    public boolean isAssignedTickets() {
        return this.tickets != null;
    }

    public void makeLottoTickets(int count) {
        this.tickets = new LottoTickets(count);
        LottoNumbers[] numbers = getLottoNumbers(count);

        this.tickets.generateTickets(numbers);
    }

    private LottoNumbers[] getLottoNumbers(int count) {

        LottoNumberGenerator generator = new RandomNumberGenerator();
        LottoNumbers[] numbers = new LottoNumbers[count];

        for(int i = 0; i < count; i++){
            numbers[i] = generator.generateNumbers();
        }
        return numbers;
    }


    public int getLottoTicketCount(int money){
        return money / TICKET_PRICE;
    }

}
