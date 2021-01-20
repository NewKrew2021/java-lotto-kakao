package lotto.domain.strategy;

import lotto.domain.BuyingListDto;
import lotto.domain.LottoTicket;

import java.util.*;

public class ManualBuyingStrategy implements BuyingStrategy{

    private BuyingListDto buyingListDto;

    public ManualBuyingStrategy(BuyingListDto buyingListDto) {
        this.buyingListDto = buyingListDto;
    }

    @Override
    public LottoTicket buyTicket() {
        List<Set<Integer>> manualLottoNumbers = this.buyingListDto.getManualLottoNumbers();
        Set<Integer> manualLottoNumber = manualLottoNumbers.get(manualLottoNumbers.size()-1);
        LottoTicket lottoTicket = new LottoTicket(manualLottoNumber);
        manualLottoNumbers.remove(manualLottoNumber);
        return lottoTicket;
    }

}
