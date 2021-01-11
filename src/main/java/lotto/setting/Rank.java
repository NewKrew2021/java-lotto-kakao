package lotto.setting;

public enum Rank {
   FIRST(1, Prize.MONEY_FOR_FIRST),
   SECOND(2, Prize.MONEY_FOR_SECOND),
   THIRD(3, Prize.MONEY_FOR_THIRD),
   FOURTH(4, Prize.MONEY_FOR_FOURTH),
   FIFTH(5, Prize.MONEY_FOR_FIFTH),
   OUT(6, Prize.MONEY_FOR_OUT);

   private int valueOfRank;
   private long prizeMoney;

   Rank(int value, long prizeMoney) {
      this.valueOfRank = value;
      this.prizeMoney = prizeMoney;
   }

   public int getValue(){
      return valueOfRank;
   }

   public long getPrize(){
      return prizeMoney;
   }
}
