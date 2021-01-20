package lotto.domain.strategy;

import lotto.domain.LottoNo;
import lotto.domain.LottoTicket;
import java.util.*;

public class AutoBuyingStrategy implements BuyingStrategy{

    private static List<Integer> lottoNumberBasket = new ArrayList<>();

    static {
        for (int i = LottoNo.MIN_NUMBER; i <= LottoNo.MAX_NUMBER; i++) {
            lottoNumberBasket.add(i);
        }
    }

    @Override
    public LottoTicket buyTicket() {
        Collections.shuffle(lottoNumberBasket);
        return new LottoTicket(new HashSet<>(lottoNumberBasket.subList(0, LottoTicket.LOTTO_NUMBER_COUNT_OF_TICKET)));
    }

}
