package lotto.domain.game;

public class LottoTicketCounts {

    private final LottoTicketCount manualCount;
    private final LottoTicketCount autoCount;

    private LottoTicketCounts(LottoTicketCount manualCount, LottoTicketCount autoCount) {
        this.manualCount = manualCount;
        this.autoCount = autoCount;
    }

    public static LottoTicketCounts from(int money, int manualCount) {
        LottoTicketCount manualTicketCount = new LottoTicketCount(manualCount);
        LottoTicketCount autoTicketCount = LottoTicketCount.fromMoney(money - manualTicketCount.calculatePrice());

        return new LottoTicketCounts(manualTicketCount, autoTicketCount);
    }

    public int getManualCount() {
        return manualCount.getTicketCount();
    }

    public int getAutoCount() {
        return autoCount.getTicketCount();
    }
}
