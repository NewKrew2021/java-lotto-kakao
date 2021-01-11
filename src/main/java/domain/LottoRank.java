package domain;

import domain.exceptions.InvalidLottoRankException;
import java.util.Arrays;
import java.util.function.Function;
import java.util.function.IntToLongFunction;

public enum LottoRank {
  LOSE(0, count -> 0),
  FIFTH(5, count -> count * 5000L),
  FOURTH(4, count -> count * 50000L),
  THIRD(3, count -> count * 1500000L),
  SECOND(2, count -> count * 30000000L),
  FIRST(1, count -> count * 2000000000L);

  private final int rank;
  private final IntToLongFunction expression;

  LottoRank(int rank, IntToLongFunction expression) {
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

  public Long sumPrize(int count) {
    return expression.applyAsLong(count);
  }
}