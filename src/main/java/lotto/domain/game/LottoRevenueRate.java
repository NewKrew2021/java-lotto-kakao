package lotto.domain.game;

public class LottoRevenueRate {

    private final double rate;

    private LottoRevenueRate(double rate) {
        this.rate = rate;
    }

    public static LottoRevenueRate of(long revenue, int totalTicketMoney) {
        double revenueRate = (double) revenue / totalTicketMoney;
        return new LottoRevenueRate(revenueRate);
    }

    public double getRate() {
        return rate;
    }

}
