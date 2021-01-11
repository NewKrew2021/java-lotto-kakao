package lottoMission.view;

import lottoMission.controller.LottoController;
import lottoMission.domain.LotteryWinnings;

import java.util.List;
import java.util.Map;

public class OutputView {

    public static void autoBoughtView(LottoController controller) {
        List<List<Integer>> lottos = controller.getLottosList();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.stream().forEach(i -> System.out.println(i));
        System.out.println();
    }

    public static void resultView(LottoController controller) {
        Map<LotteryWinnings, Integer> allLottoRankCount = controller.getAllLottoCount();
        System.out.println("당첨 통계");
        StringBuilder sb = new StringBuilder();
        for (LotteryWinnings lotteryWinnings : allLottoRankCount.keySet()) {
            String resultLine = lotteryWinnings.getCorrectNo() + "개 일치";
            if (lotteryWinnings.getHasBonus()) resultLine += ", 보너스 볼 일";
            resultLine += "(" + lotteryWinnings.getMoney() + "원) - ";
            resultLine += allLottoRankCount.get(lotteryWinnings) + "개\n";
            sb.insert(0, resultLine);
        }
        System.out.println(sb);
    }

    public static void totalEarningsView(LottoController controller) {
        String result = "총 수익률은 ";
        result += (int) Math.floor(controller.getRateOfProfit() * 100);
        System.out.println(result + "%입니다.");
    }
}
