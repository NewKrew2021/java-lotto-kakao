package lotto.domain.strategy;

import lotto.domain.LottoTicket;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public interface BuyingStrategy {
    LottoTicket buyTicket();
    LottoTicket buyTicket(List<Set<Integer>> lottoNumbers);
}
