package mission.lotto.view;

import mission.lotto.controller.LottoController;
import mission.lotto.domain.Rank;
import mission.lotto.domain.Lotto;

import java.util.List;
import java.util.Map;

public class OutputView {

    public static void autoBoughtView(LottoController lottoController) {
        List<Lotto> lottos = lottoController.getLottos();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void resultView(Map<Rank, Integer> allLottoRankCount) {
        System.out.println("당첨 통계");
        StringBuilder sb = new StringBuilder();
        for (Rank lotteryWinnings : allLottoRankCount.keySet()) {
            String resultLine = lotteryWinnings.getCorrectNo() + "개 일치";
            if (lotteryWinnings.getHasBonus()) resultLine += ", 보너스 볼 일";
            resultLine += "(" + lotteryWinnings.getMoney() + "원) - ";
            resultLine += allLottoRankCount.get(lotteryWinnings) + "개\n";
            sb.insert(0, resultLine);
        }
        System.out.println(sb);
    }

    public static void totalEarningsView(float ratio) {
        String result = "총 수익률은 ";
        result += Math.floor(ratio * 100);
        System.out.println(result + "%입니다.");
    }

}
