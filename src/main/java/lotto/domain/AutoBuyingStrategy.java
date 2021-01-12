package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class AutoBuyingStrategy implements BuyingStrategy{
    @Override
    public LottoTicket buyTicket() {
        Collections.shuffle(lottoNumberBasket);
        return new LottoTicket(new HashSet<>(lottoNumberBasket.subList(0, LottoTicket.LOTTO_NUMBER_COUNT_OF_TICKET)));
    }
}
