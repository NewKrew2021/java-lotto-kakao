package lotto.domain.strategy;

import lotto.domain.LottoDto;
import lotto.domain.LottoTicket;

import java.util.*;

public class ManualBuyingStrategy implements BuyingStrategy{

    private LottoDto lottoDto;

    public ManualBuyingStrategy(LottoDto lottoDto) {
        this.lottoDto = lottoDto;
    }

    @Override
    public LottoTicket buyTicket() {
        List<Set<Integer>> manualLottoNumbers = this.lottoDto.getManualLottoNumbers();
        Set<Integer> manualLottoNumber = manualLottoNumbers.get(manualLottoNumbers.size()-1);
        LottoTicket lottoTicket = new LottoTicket(manualLottoNumber);
        manualLottoNumbers.remove(manualLottoNumber);
        return lottoTicket;
    }

}
