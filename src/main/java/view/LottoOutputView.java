package view;

import domain.LottoResult;
import domain.LottoStatus;
import domain.Lottos;

public class LottoOutputView {
    private static final String ASK_MANUAL_LOTTO_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String LOTTO_COUNT_MESSAGE = "수동으로 %d장, 자동으로 %d개를 구입했습니다.%n";
    private static final String RESULT_MESSAGE = "%d개 일치%s (%,d원) - %d개%n";


    public static void askManualLottoNumbers() {
        System.out.println(ASK_MANUAL_LOTTO_NUMBERS);
    }

    public static void printBuyLottoCount(int manualLottoCount, int autoLottoCount) {
        System.out.printf(LOTTO_COUNT_MESSAGE, manualLottoCount, autoLottoCount);
    }

    public static void printLottos(Lottos lottos) {
        System.out.println(lottos);
    }

    public static void printResult(LottoResult lottoResult, long profit) {
        System.out.println("당첨 통계\n-----------");

        for (LottoStatus lottoStatus : LottoStatus.values()) {
            System.out.printf(RESULT_MESSAGE, lottoStatus.getMatchingCount(),
                    printBonus(lottoStatus), lottoStatus.getWinnings(), lottoResult.get(lottoStatus));
        }

        System.out.println("총 수익률은 " + profit + "% 입니다.");
    }

    private static String printBonus(LottoStatus lottoStatus) {
        if (lottoStatus.getWinnings() == LottoStatus.SECOND.getWinnings()) {
            return ", 보너스 볼 일치";
        }
        return "";
    }

}

