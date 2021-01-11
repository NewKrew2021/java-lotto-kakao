package lotto.view;

import lotto.domain.LottoNumbers;

import java.util.List;

public class LottoOutputView {

    public static void printLottoCount(List<LottoNumbers> lottoTickets) {
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");
        for( LottoNumbers lottoTicket : lottoTickets ) {
            System.out.println(lottoTicket.toString());
        }
    }

    public static void printWinningStatistics(List<LottoNumbers> lottos) {

    }

}
