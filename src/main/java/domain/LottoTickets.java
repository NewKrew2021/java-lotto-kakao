package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {

    private List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public WinningInfo getWinningInfo(LottoWinningNumber lottoWinningNumber) {
        List<Integer> winningInfo = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));

        for (LottoTicket lottoTicket : lottoTickets) {
            updateWinningInfo(lottoTicket, lottoWinningNumber, winningInfo);
        }

        return new WinningInfo(winningInfo);
    }

    private void updateWinningInfo(LottoTicket lottoTicket, LottoWinningNumber lottoWinningNumber, List<Integer> winningInfo){
        int winningInfoIndex = 0;
        int count =  lottoWinningNumber.getMatchedCount(lottoTicket);

        if ((count == 5 && lottoWinningNumber.isContainsBounusNumber(lottoTicket)) || count == 6) {
            winningInfoIndex = 1;
        }

        winningInfoIndex += count - 3;

        if (winningInfoIndex >= 0) {
            winningInfo.set(winningInfoIndex, winningInfo.get(winningInfoIndex) + 1);
        }
    }

    public List<List<Integer>> getLottoTickets() {
        return lottoTickets.stream()
                .map(LottoTicket::getLottoTicketInfo)
                .collect(Collectors.toList());
    }

    public int size() {
        return this.lottoTickets.size();
    }
}
