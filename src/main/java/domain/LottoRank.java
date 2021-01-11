package domain;

import domain.exceptions.InvalidLottoRankException;
import java.util.Arrays;
import java.util.function.Function;

public enum LottoRank {
  FIFTH(5, count -> count * 5000L),
  FOURTH(4, count -> count * 50000L),
  THIRD(3, count -> count * 1500000L),
  SECOND(2, count -> count * 30000000L),
  FIRST(1, count -> count * 2000000000L);

  private final int rank;
  private final Function<Long, Long> expression;

  LottoRank(int rank, Function<Long, Long> expression) {
    this.rank = rank;
    this.expression = expression;
  }

  public static LottoRank of(int lottoRank) {
    return Arrays.stream(LottoRank.values())
        .filter(rank -> lottoRank == rank.getRank())
        .findAny()
        .orElseThrow(InvalidLottoRankException::new);
  }

  public int getRank() {
    return rank;
  }

  public Long getPrize(int count) {
    return expression.apply((long) count);
  }
}