package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoTickets {

  private final List<LottoTicket> lottoTickets;

  public LottoTickets(List<LottoTicket> lottoTickets) {
    this.lottoTickets = lottoTickets;
  }

  public List<List<Integer>> getLottoTicketsInfo() {
    return lottoTickets.stream()
        .map(LottoTicket::getLottoTicketInfo)
        .collect(Collectors.toList());
  }

  public WinningInfo getWinningInfo(LottoWinningNumber lottoWinningNumber) {
    Map<LottoRank, Integer> winningInfo = new HashMap<>();

    for (LottoTicket lottoTicket : lottoTickets) {
      int matchedCount = lottoWinningNumber.getMatchedCount(lottoTicket);
      boolean matchedBounus = lottoWinningNumber.isContainsBounusNumber(lottoTicket);

      LottoRank rank = LottoRank.of(getRank(matchedCount, matchedBounus));
      winningInfo.put(rank, winningInfo.getOrDefault(rank, 0) + 1);
    }

    return new WinningInfo(winningInfo);
  }

  private int getRank(int matchedCount, boolean matchedBounus) {
    if (matchedCount == LottoTicket.LOTTO_NUMBERS_LENGTH) {
      return 1;
    }

    if (matchedCount == LottoTicket.LOTTO_NUMBERS_LENGTH - 1 && matchedBounus) {
      return 2;
    }

    if (matchedCount > 2) {
      return LottoTicket.LOTTO_NUMBERS_LENGTH - matchedCount + 2;
    }

    return 0;
  }

  public int size() {
    return this.lottoTickets.size();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LottoTickets that = (LottoTickets) o;
    return Objects.equals(lottoTickets, that.lottoTickets);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lottoTickets);
  }
}
