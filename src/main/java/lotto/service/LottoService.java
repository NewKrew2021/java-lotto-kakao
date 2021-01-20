package lotto.service;

import lotto.domain.*;

import java.util.*;

public class LottoService {

    public void buyLottoTickets(BuyingListDto buyingListDto, LottoDto lottoDto) {
        BuyingList buyingList = buyingListDto.getBuyingList();
        List<LottoTicket> lottoTickets = new ArrayList<>(buyingList.buyAllTickets(buyingListDto));

        lottoDto.setLottoTickets(lottoTickets);
    }

    public StatisticsResult winningStatistics(LottoDto lottoDto) {
        StatisticsResult statisticsResult = new StatisticsResult();
        List<LottoTicket> lottoTickets = lottoDto.getLottoTickets();
        WinningLottoNos winningLottoNos = lottoDto.getWinningLottoNos();

        for (LottoTicket lottoTicket : lottoTickets) {
            statisticsResult.increaseTypeCount(winningLottoNos.rankWinning(lottoTicket));
        }

        return statisticsResult;
    }

    public void makePurchaseList(BuyingListDto buyingListDto) {
        int money = buyingListDto.getMoney();
        int manualTicketCount = buyingListDto.getManualTicketCount();
        List<Set<Integer>> manualLottoNumbers = buyingListDto.getManualLottoNumbers();
        BuyingList buyingList = new BuyingList(money, manualLottoNumbers);

        buyingListDto.setBuyingList(buyingList);

    }

    public void makeWinningLottoNumbers(LottoDto lottoDto) {
        Set<Integer> winningLottoOnlyNumbers = lottoDto.getWinningLottoOnlyNumbers();
        int bonusNumber = lottoDto.getBonusNumber();
        WinningLottoNos winningLottoNos = new WinningLottoNos(winningLottoOnlyNumbers, bonusNumber);

        lottoDto.setWinningLottoNos(winningLottoNos);
    }
}
