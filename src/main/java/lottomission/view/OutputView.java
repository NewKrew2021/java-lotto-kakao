package lottomission.view;

import lottomission.domain.LotteryWinnings;
import lottomission.domain.LottoResult;
import lottomission.domain.Lottos;
import lottomission.domain.UserMoney;

import java.util.List;
import java.util.Map;

public class OutputView {

    public static void lottoBoughtView(Lottos lottos) {
        List<List<Integer>> lottosNumberList = lottos.getLottosNumberList();
        System.out.println(lottosNumberList.size() + "개를 구매했습니다.");
        lottosNumberList.stream().forEach(i -> System.out.println(i));
        System.out.println();
    }

    public static void resultView(LottoResult lottoResult) {
        Map<LotteryWinnings, Integer> allLottoRankCount = lottoResult.getRankCount();
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

    public static void totalEarningsView(LottoResult lottoResult, UserMoney userMoney) {
        String result = "총 수익률은 ";
        result += (int) Math.floor(lottoResult.getRateOfProfitResult(userMoney) * 100);
        System.out.println(result + "%입니다.");
    }
}
