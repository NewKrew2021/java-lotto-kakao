package lotto.domain.strategy;

import lotto.domain.LottoTicket;
import lotto.domain.PurchaseList;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public interface BuyingStrategy {
    List<LottoTicket> buyTicket();
}
