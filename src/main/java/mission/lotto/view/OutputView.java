package mission.lotto.view;

import mission.lotto.domain.Lotto;
import mission.lotto.domain.Lottos;
import mission.lotto.domain.Rank;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    private static final String boughtLottoMessage = "수동으로 %d개, 자동으로 %d개를 구매했습니다.";
    private static final String LottoReportFrontMessage = "%d개 일치";
    private static final String hasBonusMessage = ", 보너스 볼 일치";
    private static final String LottoReportRearMessage = "(%d원) - %d개";

    public static void boughtLottosView(int manualCount, Lottos lottos) {
        List<Lotto> unPacked = lottos.getLottos();
        System.out.println(String.format(boughtLottoMessage, manualCount, unPacked.size() - manualCount));
        for (Lotto lotto : unPacked) {
            System.out.println(lotto);
        }
    }

    public static void resultView(Map<Rank, Integer> allLottoRank) {
        System.out.println("당첨 통계");
        System.out.println(getPreDefinedLottoReport(allLottoRank));
    }

    public static void totalEarningsView(float ratio) {
        String result = "총 수익률은 ";
        result += Math.floor(ratio * 100);
        System.out.println(result + "%입니다.");
    }

    private static String getPreDefinedLottoReport(Map<Rank, Integer> allLottoRankCount) {
        return allLottoRankCount.keySet().stream()
                .map(rank -> {
                    String message = makeBaseMessage(rank.getHasBonus());
                    return String.format(message, rank.getCorrectNo(), rank.getMoney(), allLottoRankCount.get(rank));
                })
                .collect(Collectors.joining("\n"));
    }

    private static String makeBaseMessage(boolean hasBonus) {
        if (hasBonus) return LottoReportFrontMessage + hasBonusMessage + LottoReportRearMessage;
        return LottoReportFrontMessage + LottoReportRearMessage;
    }

}
