package lotto.domain;

import lotto.domain.vo.Price;

public class Buyer {
    private final int TICKET_PRICE = 1000;
    private final int manualChoose;
    private final Price insertPrice;
    private LottoTickets allTickets;

    public Buyer(Price insertPrice, int manualChooseTicketAmount) {
        if (isNegative(manualChooseTicketAmount)) {
            throw new IllegalArgumentException("Cannot choose negative amount of manual tickets");
        }
        if (hasNotEnoughBudget(getTotalTicketAmount((int) insertPrice.getPrice()), manualChooseTicketAmount)) {
            throw new IllegalArgumentException(
                    String.format("Not enough budget to buy %d tickets", manualChooseTicketAmount));
        }

        this.insertPrice = insertPrice;
        this.manualChoose = manualChooseTicketAmount;
    }

    public void setLottoTickets(LottoTickets tickets) {
        allTickets = tickets;
    }

    public Price getInsertPrice() {
        return insertPrice;
    }

    public int getChange() {
        return (int) insertPrice.getPrice() % 1000;
    }

    public long getInvestedMoney() {
        return (long) getTotalTicketAmount() * TICKET_PRICE;
    }

    public int getTotalTicketAmount() {
        return (int) insertPrice.getPrice() / TICKET_PRICE;
    }

    public int getManualChooseTicketAmount() {
        return manualChoose;
    }

    public int getRandomChooseTicketAmount() {
        return getTotalTicketAmount() - getManualChooseTicketAmount();
    }

    public LottoTickets getLottoTickets() {
        return allTickets;
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
