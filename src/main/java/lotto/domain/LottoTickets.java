package lotto.domain;

import lotto.domain.vo.LottoNumber;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {
    private final List<LottoNumbers> tickets;

    public LottoTickets(List<LottoNumbers> tickets) {
        this.tickets = Collections.unmodifiableList(tickets);
    }

    public List<List<Integer>> getAllTicketNumbers() {
        return tickets.stream()
                .map(LottoNumbers::getNumbersInTicket)
                .collect(Collectors.toList());
    }

    public List<Integer> getMatchCountsInOrder(LottoNumbers luckyNumbers) {
        return tickets.stream()
                .map(ticket -> ticket.getMatchCount(luckyNumbers))
                .collect(Collectors.toList());
    }

    public List<Boolean> getContainsBonusNumberInOrder(LottoNumber bonusNumber) {
        return tickets.stream()
                .map(ticket -> ticket.isMatchBonus(bonusNumber))
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTickets that = (LottoTickets) o;
        return (tickets.size() == that.tickets.size()) && this.tickets.containsAll(that.tickets);
    }
}
