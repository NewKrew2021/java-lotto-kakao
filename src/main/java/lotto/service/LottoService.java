package lotto.service;

import lotto.domain.*;

import java.util.*;

public class LottoService {

    private LottoDto lottoDto;

    public LottoService(LottoDto lottoDto) {
        this.lottoDto = lottoDto;
    }

    public void buyLottoTickets() {
        PurchaseList purchaseList = lottoDto.getPurchaseList();
        List<LottoTicket> lottoTickets = new ArrayList<>(purchaseList.buyAllTickets(lottoDto));

        lottoDto.setLottoTickets(lottoTickets);
    }

    public void winningStatistics() {
        StatisticsResult statisticsResult = new StatisticsResult();
        List<LottoTicket> lottoTickets = lottoDto.getLottoTickets();
        WinningLottoNos winningLottoNos = lottoDto.getWinningLottoNos();

        for (LottoTicket lottoTicket : lottoTickets) {
            statisticsResult.increaseTypeCount(winningLottoNos.rankWinning(lottoTicket));
        }

        lottoDto.setStatisticsResult(statisticsResult);
    }

    public void makePurchaseList() {
        int money = lottoDto.getMoney();
        List<Set<Integer>> manualLottoNumbers = lottoDto.getManualLottoNumbers();
        PurchaseList purchaseList = new PurchaseList(money, manualLottoNumbers);

        lottoDto.setPurchaseList(purchaseList);

    }

    public void makeWinningLottoNumbers() {
        Set<Integer> winningLottoOnlyNumbers = lottoDto.getWinningLottoOnlyNumbers();
        int bonusNumber = lottoDto.getBonusNumber();
        WinningLottoNos winningLottoNos = new WinningLottoNos(winningLottoOnlyNumbers, bonusNumber);

        lottoDto.setWinningLottoNos(winningLottoNos);
    }
}
