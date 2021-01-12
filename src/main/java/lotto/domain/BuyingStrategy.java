package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public interface BuyingStrategy {

    static final List<Integer> lottoNumberBasket = makeLottoNumberBasket();
    LottoTicket buyTicket();

    static List<Integer> makeLottoNumberBasket() {
        List<Integer> nums = new ArrayList<>();
        for (int i = LottoNo.MIN_NUMBER; i <= LottoNo.MAX_NUMBER; i++) {
            nums.add(i);
        }
        return nums;
    }
}
