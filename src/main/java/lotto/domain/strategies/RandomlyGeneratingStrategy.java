package lotto.domain.strategies;

import lotto.domain.Ticket;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomlyGeneratingStrategy implements GeneratingStrategy {
    private final Random random = new Random();
    private final int limitOfGeneration;

    public RandomlyGeneratingStrategy(int limitOfGeneration) {
        this.limitOfGeneration = limitOfGeneration;
    }

    @Override
    public Set<Integer> generate() {
        Set<Integer> genNumbers = new HashSet<>();
        int maxValue = Ticket.UPPER_LIMIT_OF_NUMBER;
        int minValue = Ticket.LOWER_LIMIT_OF_NUMBER;

        do {
            int currentGeneratedNumber = random.nextInt(maxValue - minValue + 1) + minValue;
            genNumbers.add(currentGeneratedNumber);
        } while (genNumbers.size() < Ticket.TICKET_SIZE);

        return genNumbers;
    }

    @Override
    public int getLimit() {
        return limitOfGeneration;
    }
}
