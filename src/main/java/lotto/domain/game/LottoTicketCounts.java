package lotto.domain.game;

import static lotto.domain.game.LottoTicketCount.MONEY_PER_LOTTO;

public class LottoTicketCounts {

    private final LottoTicketCount manualCount;
    private final LottoTicketCount autoCount;

    private LottoTicketCounts(LottoTicketCount manualCount, LottoTicketCount autoCount) {
        this.manualCount = manualCount;
        this.autoCount = autoCount;
    }

    public static LottoTicketCounts from(int money, int manualCount) {
        LottoTicketCount manualTicketCount = new LottoTicketCount(manualCount);

        int autoCount = money / MONEY_PER_LOTTO - manualTicketCount.getTicketCount();

        return new LottoTicketCounts(manualTicketCount, new LottoTicketCount(autoCount));
    }

    public int getManualCount() {
        return manualCount.getTicketCount();
    }

    public int getAutoCount() {
        return autoCount.getTicketCount();
    }
}
