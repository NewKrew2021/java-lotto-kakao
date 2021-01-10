package domain;

import dto.Amount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {

    private final List<Lotto> lottos;

    public LottoTickets(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LottoTickets of(NumberGenerateStrategy strategy, Amount amount) {
        int count = amount.getCount();
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            tickets.add(strategy.generate());
        }
        return new LottoTickets(tickets);
    }

    public WinningInfo getWinningInfo(LottoWinningNumber lottoWinningNumber) {
        List<Integer> winningInfo = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));

        for (Lotto lotto : lottos) {
            updateWinningInfo(lotto, lottoWinningNumber, winningInfo);
        }

        return new WinningInfo(winningInfo);
    }

    private void updateWinningInfo(Lotto lotto, LottoWinningNumber lottoWinningNumber, List<Integer> winningInfo) {
        int winningInfoIndex = 0;
        int count = lottoWinningNumber.getMatchedCount(lotto);

        if ((count == 5 && lottoWinningNumber.isContainsBounusNumber(lotto)) || count == 6) {
            winningInfoIndex = 1;
        }

        winningInfoIndex += count - 3;

        if (winningInfoIndex >= 0) {
            winningInfo.set(winningInfoIndex, winningInfo.get(winningInfoIndex) + 1);
        }
    }

    public List<List<Integer>> getLottoTickets() {
        return lottos.stream()
                .map(Lotto::getLottoTicketInfo)
                .collect(Collectors.toList());
    }

    public int size() {
        return this.lottos.size();
    }
}
