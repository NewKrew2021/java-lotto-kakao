package domain;

import domain.exceptions.InvalidLottoRankException;
import java.util.Arrays;
import java.util.function.IntToLongFunction;

public enum LottoRank {
  LOSE(0, count -> 0),
  FIFTH(3, count -> count * 5000L),
  FOURTH(4, count -> count * 50000L),
  THIRD(5, count -> count * 1500000L),
  SECOND(5, count -> count * 30000000L),
  FIRST(6, count -> count * 2000000000L);

  private final int matchCount;
  private final IntToLongFunction expression;

  LottoRank(int matchCount, IntToLongFunction expression) {
    this.matchCount = matchCount;
    this.expression = expression;
  }

  public static LottoRank of(int matchCount, boolean matchBonus) {
    if (matchCount < FIFTH.matchCount) {
      return LOSE;
    }

    if (matchCount == SECOND.matchCount) {
      return secondOrThird(matchBonus);
    }

    return Arrays.stream(LottoRank.values())
        .filter(rank -> rank.matchCount == matchCount)
        .findAny()
        .orElseThrow(InvalidLottoRankException::new);
  }

  private static LottoRank secondOrThird(boolean matchBonus) {
    if (matchBonus) {
      return SECOND;
    }
    return THIRD;
  }

  public Long sumPrize(int count) {
    return expression.applyAsLong(count);
  }
}