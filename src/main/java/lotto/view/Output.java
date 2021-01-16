package lotto.view;

import lotto.domain.LottoPaper;
import lotto.domain.Rank;
import lotto.dto.LottoNumberData;
import lotto.domain.LottoResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Output {

    private Output(){
        throw new IllegalStateException("Output class is not allowed to construct.");
    }

    public static void printCountOfPurchase(long manualCount, long autoCount) {
        System.out.printf("\n수동으로 %d장, 자동으로 %d장을 구매했습니다.\n", manualCount, autoCount);
    }

    public static void printPurchasedLottoToUser(LottoPaper paper) {
        LottoNumberData data = paper.getLottoNumberData();
        List<Set<Integer>> rawData = data.getNumberData();
        for (Set<Integer> integers : rawData) {
            List<Integer> integerList = new ArrayList<>(integers);
            Collections.sort(integerList);
            System.out.println(integerList);
        }
    }

    public static void printStatisticsToUser(LottoResult result) {
        System.out.println("당첨 통계");
        System.out.println("----------");
        System.out.println("3개 일치 (5,000원) - " + result.getCountOf(Rank.FIFTH) + "개");
        System.out.println("4개 일치 (50,000원) - " + result.getCountOf(Rank.FOURTH) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + result.getCountOf(Rank.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result.getCountOf(Rank.SECOND) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + result.getCountOf(Rank.FIRST) + "개");
        System.out.println("총 수익률은 " + result.getRate() + "입니다.");
    }
}