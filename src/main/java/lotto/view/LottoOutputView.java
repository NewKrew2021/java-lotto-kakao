package lotto.view;

import lotto.domain.LottoGroup;
import lotto.domain.LottoResult;
import lotto.domain.PurchaseMoney;
import lotto.domain.Rank;

public class LottoOutputView {

    public static void outputPurchaseAmount(int manualAmount, int autoAmount) {
        System.out.println(String.format("\n수동으로 %d개, 자동으로 %d개를 구매했습니다.", manualAmount, autoAmount));
    }

    public static void outputLottoGroup(LottoGroup lottoGroup) {
        if (lottoGroup.getLottoCount() > 0) {
            System.out.println("[" + lottoGroup.toString().replace("\n", "]\n[") + "]");
        }
    }

    public static void outputLottoResult(LottoResult lottoResult, PurchaseMoney purchaseMoney) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        System.out.println(getRankResult(lottoResult, Rank.FIFTH));
        System.out.println(getRankResult(lottoResult, Rank.FOURTH));
        System.out.println(getRankResult(lottoResult, Rank.THIRD));
        System.out.println(getRankResult(lottoResult, Rank.SECOND));
        System.out.println(getRankResult(lottoResult, Rank.FIRST));
        System.out.println("총 수익률은 " + lottoResult.getProfitRatio(purchaseMoney) + "%입니다.");
    }

    private static String getRankResult(LottoResult lottoResult, Rank rank) {
        return rank.getDescription() + " (" + rank.getPrize() + "원) - " + lottoResult.getRankCount(rank) + "개";
    }

}
