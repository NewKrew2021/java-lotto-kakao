package mission.lotto.view;

import mission.lotto.domain.Lotto;
import mission.lotto.domain.Lottos;
import mission.lotto.domain.Rank;
import mission.lotto.util.Statistics;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    private static final String boughtLottoMessage = "수동으로 %d개, 자동으로 %d개를 구매했습니다.";
    private static final String statisticsTitleMessage = "당첨 통계";
    private static final String lottoReportFrontMessage = "%d개 일치";
    private static final String hasBonusMessage = ", 보너스 볼 일치";
    private static final String lottoReportRearMessage = "(%d원) - %d개";
    private static final String earningFrontMessage = "총 수익률은 ";
    private static final String earningRearMessage = "% 입니다.";

    public static void boughtLottosView(int manualCount, Lottos lottos) {
        List<Lotto> unPacked = lottos.getLottos();
        System.out.println(String.format(boughtLottoMessage, manualCount, unPacked.size() - manualCount));
        for (Lotto lotto : unPacked) {
            System.out.println(lotto);
        }
    }

    public static void resultView(Statistics statistics) {
        System.out.println(statisticsTitleMessage);
        System.out.println(PreDefinedLottoReport(statistics));
    }

    private static String PreDefinedLottoReport(Statistics statistics) {
        return statistics.getLottoRanks().entrySet().stream()
                .map(OutputView::rankCountMessage)
                .collect(Collectors.joining("\n"));
    }

    private static String rankCountMessage(Map.Entry<Rank, Integer> entry) {
        Rank rank = entry.getKey();
        int count = entry.getValue();
        String message = makeBaseMessage(rank.getHasBonus());
        return String.format(message, count, rank.getMoney(), count);
    }

    private static String makeBaseMessage(boolean hasBonus) {
        if (hasBonus) return lottoReportFrontMessage + hasBonusMessage + lottoReportRearMessage;
        return lottoReportFrontMessage + lottoReportRearMessage;
    }

    public static void totalEarningsView(float ratio) {
        String result = earningFrontMessage + Math.floor(ratio * 100) + earningRearMessage;
        System.out.println(result);
    }

}
