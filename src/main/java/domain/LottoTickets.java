package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {

    public static final int MIN_MATCH_COUNT = 3;
    private List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public WinningInfo getWinningInfo(LottoWinningNumber lottoWinningNumber) {
        List<Integer> winningInfo = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));
        for (LottoTicket lottoTicket : lottoTickets) {
            checkLottoTicket(lottoWinningNumber, winningInfo, lottoTicket);
        }

        return new WinningInfo(winningInfo);
    }

    private void checkLottoTicket(LottoWinningNumber lottoWinningNumber, List<Integer> winningInfo,
        LottoTicket lottoTicket) {
        int winningInfoIndex = 0;
        int matchedCount = lottoWinningNumber.getMatchedCount(lottoTicket);

        if (matchedCount < MIN_MATCH_COUNT)
            return;

        if (isSecond(lottoWinningNumber, lottoTicket, matchedCount) || isFirst(matchedCount)) {
            winningInfoIndex = 1;
        }

        updateWinningInfo(winningInfo, winningInfoIndex, matchedCount);
    }

    private void updateWinningInfo(List<Integer> winningInfo, int winningInfoIndex, int matchedCount) {
        winningInfoIndex += matchedCount - MIN_MATCH_COUNT;
        winningInfo.set(winningInfoIndex, winningInfo.get(winningInfoIndex) + 1);
    }

    private boolean isFirst(int matchedCount) {
        return matchedCount == LottoTicket.LOTTO_NUMBERS_LENGTH;
    }

    private boolean isSecond(LottoWinningNumber lottoWinningNumber, LottoTicket lottoTicket,
        int matchedCount) {
        return matchedCount == LottoTicket.LOTTO_NUMBERS_LENGTH - 1 && lottoWinningNumber.isContainsBounusNumber(lottoTicket);
    }

    public int size() {
        return this.lottoTickets.size();
    }
}
