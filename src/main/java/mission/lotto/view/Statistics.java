package mission.lotto.view;

import mission.lotto.domain.Rank;

import java.util.Map;

public class Statistics {

    public static String getPreDefinedLottoReport(Map<Rank, Integer> allLottoRankCount) {
        StringBuilder result = new StringBuilder();
        for (Rank lotteryWinnings : allLottoRankCount.keySet()) {
            String resultLine = lotteryWinnings.getCorrectNo() + "개 일치";
            if (lotteryWinnings.getHasBonus()) resultLine += ", 보너스 볼 일";
            resultLine += "(" + lotteryWinnings.getMoney() + "원) - ";
            resultLine += allLottoRankCount.get(lotteryWinnings) + "개\n";
            result.insert(0, resultLine);
        }
        return result.toString();
    }

}
