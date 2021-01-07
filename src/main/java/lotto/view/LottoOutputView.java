package lotto.view;

import lotto.domain.LottoNos;

import java.util.List;

public class LottoOutputView {

    public static void printLottoCount(List<LottoNos> lottoTickets) {
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");
        for( LottoNos lottoTicket : lottoTickets ) {
            System.out.println(lottoTicket.toString());
        }
    }

    public static void printWinningStatistics(List<LottoNos> lottoTic) {

    }

}
