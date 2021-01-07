package lotto.view;

import lotto.LottoGroup;
import lotto.LottoResult;
import lotto.PurchaseMoney;
import lotto.Rank;

public class LottoOutputView {

    public static void outputPurchaseAmount(int amount) {
        System.out.println(String.format("%d개를 구매했습니다.", amount));
    }

    public static void outputLottoGroup(LottoGroup lottoGroup) {
        System.out.println(lottoGroup.toString());
        System.out.println();
    }

    public static void outputLottoResult(LottoResult lottoResult, PurchaseMoney purchaseMoney){
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        System.out.println(getRankResult(lottoResult, Rank.FIFTH));
        System.out.println(getRankResult(lottoResult, Rank.FOURTH));
        System.out.println(getRankResult(lottoResult, Rank.THIRD));
        System.out.println(getRankResult(lottoResult, Rank.SECOND));
        System.out.println(getRankResult(lottoResult, Rank.FIRST));
        System.out.println("총 수익률은 " + lottoResult.getProfitRatio(purchaseMoney) + "%입니다.");
    }

    private static String getRankResult(LottoResult lottoResult, Rank rank){
        return rank.getDescription() + " (" + rank.getPrize() + "원) - " + lottoResult.getRankCount(rank) + "개";
    }

}
