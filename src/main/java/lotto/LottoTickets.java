package lotto;

import java.util.Collections;
import java.util.List;

public class LottoTickets {
    private final List<LottoNumbers> lottoNumbers;

    public LottoTickets(List<LottoNumbers> lottoNumbers) {
        this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
    }

    public List<LottoNumbers> getLottoTickets() {
        return lottoNumbers;
    }
}
