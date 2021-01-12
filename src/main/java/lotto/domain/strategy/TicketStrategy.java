package lotto.domain.strategy;

import lotto.domain.Number;

import java.util.Set;

@FunctionalInterface
public interface TicketStrategy {
    public Set<Number> makeNumbers();
}
