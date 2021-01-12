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

    public static void printCountOfPurchase(long count){
        System.out.println(count + "개를 구매했습니다.");
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