package lotto.domain;

import java.util.Objects;
import java.util.Set;

public class LottoTicket {

    private final LottoNumbers numbers;

    public LottoTicket(LottoNumbers numbers){
        this.numbers = numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoTicket)) return false;
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
