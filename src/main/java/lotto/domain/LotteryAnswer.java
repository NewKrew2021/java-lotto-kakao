package lotto.domain;

import java.util.Objects;

public class LotteryAnswer {
    private final Lottery lottery;
    private final LotteryNumber bonusNumber;

    public LotteryAnswer(Lottery answerLottery, LotteryNumber bonusNumber) {
        if (Lottery.isDuplicatedLotteryNumbers(answerLottery, bonusNumber)) {
            throw new IllegalArgumentException(Lottery.MSG_DUPLICATED_LOTTERYNUMBER);
        }
        this.lottery = answerLottery;
        this.bonusNumber = bonusNumber;
    }

    public LotteryAnswer(int[] answerInts, int bonusNumber) {
        this(new Lottery(answerInts), LotteryNumber.of(bonusNumber));
    }

    public Lottery getLottery() {
        return lottery;
    }

    public LotteryNumber getBonusNumber() {
        return bonusNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotteryAnswer that = (LotteryAnswer) o;
        return Objects.equals(lottery, that.lottery) && Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottery, bonusNumber);
    }
}
