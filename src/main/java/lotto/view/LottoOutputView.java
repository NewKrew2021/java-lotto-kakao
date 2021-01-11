package lotto.view;

import lotto.domain.LottoGroup;
import lotto.domain.LottoResult;
import lotto.domain.PurchaseMoney;
import lotto.domain.Rank;

import java.util.Arrays;

public class LottoOutputView {
    public static final String PURCHASE_COUNT_MESSAGE = "\n수동으로 %d장, 자동으로 %d개를 구매했습니다.\n";
    public static final String WINNING_RESULT_MESSAGE = "\n당첨 통계\n---------";
    public static final String PROFIT_RATIO_MESSAGE = "총 수익률은 %s%%입니다.";
    public static final String RANK_RESULT_MESSAGE = "%s (%d원) - %d개";

    public static void outputPurchaseQuantity(int manualQuantity, LottoGroup lottoGroup) {
        System.out.printf(PURCHASE_COUNT_MESSAGE, manualQuantity, lottoGroup.getLottoCount() - manualQuantity);
    }

    public static void outputLottoGroup(LottoGroup lottoGroup) {
        System.out.println(lottoGroup.toString());
        System.out.println();
    }

    public static void outputLottoResult(LottoResult lottoResult, PurchaseMoney purchaseMoney) {
        System.out.println(WINNING_RESULT_MESSAGE);
        Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.NOTHING)
                .forEach(rank -> System.out.println(getRankResult(lottoResult, rank)));
        System.out.printf(PROFIT_RATIO_MESSAGE, lottoResult.getProfitRatio(purchaseMoney));
    }

    private static String getRankResult(LottoResult lottoResult, Rank rank) {
        return String.format(RANK_RESULT_MESSAGE, rank.getDescription(), rank.getPrize(), lottoResult.getRankCount(rank));
    }

}
