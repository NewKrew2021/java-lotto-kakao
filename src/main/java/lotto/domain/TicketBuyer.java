package lotto.domain;

import lotto.domain.vo.Price;

public class TicketBuyer {
    private final int TICKET_PRICE = 1000;
    private final int manualCount;
    private final Price price;
    private LottoTickets tickets;

    public TicketBuyer(Price price, int manualCount) {
        if (isNegative(manualCount)) {
            throw new IllegalArgumentException("Cannot choose negative amount of manual tickets");
        }
        if (hasNotEnoughBudget(getTotalTicketAmount((int) price.getPrice()), manualCount)) {
            throw new IllegalArgumentException(
                    String.format("Not enough budget to buy %d tickets", manualCount));
        }

        this.price = price;
        this.manualCount = manualCount;
    }

    public void issueTickets(LottoTickets tickets) {
        this.tickets = tickets;
    }

    public Price getPrice() {
        return price;
    }

    public int getChange() {
        return (int) price.getPrice() % 1000;
    }

    public long getInvestedMoney() {
        return (long) getTotalTicketAmount() * TICKET_PRICE;
    }

    public int getTotalTicketAmount() {
        return (int) price.getPrice() / TICKET_PRICE;
    }

    public int getManualCount() {
        return manualCount;
    }

    public int getRandomCount() {
        return getTotalTicketAmount() - getManualCount();
    }

    public LottoTickets getLottoTickets() {
        return tickets;
    }

    private boolean isNegative(int value) {
        return value < 0;
    }

    private boolean hasNotEnoughBudget(int totalTicketCount, int manualChoose) {
        return manualChoose > totalTicketCount;
    }

    private int getTotalTicketAmount(int price) {
        return price / TICKET_PRICE;
    }
}
