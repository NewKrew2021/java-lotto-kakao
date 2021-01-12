package lotto.domain.strategy;

import lotto.domain.LottoTicket;
import lotto.domain.Number;

import java.util.Set;
import java.util.TreeSet;

public class RandomTicketStrategy implements TicketStrategy{
    @Override
    public Set<Number> makeNumbers() {
        return new TreeSet<>(Number.randomNumbers(LottoTicket.BALL_COUNT));
    }
}
