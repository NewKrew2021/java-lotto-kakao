package lotto.domain;

import lotto.setting.Prize;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum Rank {
   OUT(-1, Prize.MONEY_FOR_OUT),
   FIFTH(3, Prize.MONEY_FOR_FIFTH),
   FOURTH(4,Prize.MONEY_FOR_FOURTH),
   THIRD(5, Prize.MONEY_FOR_THIRD),
   SECOND(5, Prize.MONEY_FOR_SECOND),
   FIRST(6, Prize.MONEY_FOR_FIRST);

   private int matchCount;
   private long prize;
   Map<Integer, Rank> cache = new HashMap<>();

   Rank(int matchCount, long prize) {
      this.matchCount = matchCount;
      this.prize = prize;
   }

   public static Rank getRankAccordingTo(int matchCount, boolean matchBonusBall) {
      if (Rank.SECOND.getMatchCount() == matchCount && matchBonusBall) {
         return Rank.SECOND;
      }

      return Arrays.stream(Rank.values())
              .filter(rank -> rank.matchCount == matchCount)
              .findFirst()
              .orElse(OUT);
   }

   private int getMatchCount() {
      return matchCount;
   }

   public long getPrize() {
      return prize;
   }
}
