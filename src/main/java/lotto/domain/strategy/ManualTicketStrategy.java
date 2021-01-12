package lotto.domain.strategy;

import lotto.domain.Number;
import lotto.view.LottoGameInputView;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class ManualTicketStrategy implements TicketStrategy {
    private final String DELIMITER = ",";

    @Override
    public Set<Number> makeNumbers() {
        return Arrays.stream(LottoGameInputView.inputManualTicket().split(DELIMITER))
                .map(String::trim)
                .map(Number::of)
                .collect(Collectors.toSet());
    }
}
