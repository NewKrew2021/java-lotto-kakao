package lotto.domain;

import java.util.Collections;
import java.util.HashSet;

public class AutoBuyingStrategy implements BuyingStrategy{
    @Override
    public LottoTicket buyTicket() {
        Collections.shuffle(LottoNo.lottoNumberBasket);
        return new LottoTicket(new HashSet<>(LottoNo.lottoNumberBasket.subList(0, LottoTicket.LOTTO_NUMBER_COUNT_OF_TICKET)));
    }
}
