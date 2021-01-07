package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LotteryAnswer {
    private List<LotteryNumber> answerNumber;
    private LotteryNumber bonusNumber;

    public LotteryAnswer(List<LotteryNumber> answerNumbers, LotteryNumber bonusNumber) {
        if (LotteryUtil.isInvalidSizeLotteryNumbers(answerNumbers)) {
            throw new IllegalArgumentException(LotteryUtil.MSG_WRONG_LOTTERY_LENGTH);
        }
        if (LotteryUtil.isDuplicatedLotteryNumbers(answerNumbers, bonusNumber)) {
            throw new IllegalArgumentException(LotteryUtil.MSG_DUPLICATED_LOTTERYNUMBER);
        }
        this.answerNumber = answerNumbers;
        this.bonusNumber = bonusNumber;
    }

    public LotteryAnswer(int[] answerInts, int bonusNumber) {
        this(
                Arrays.stream(answerInts)
                        .mapToObj(LotteryNumber::new)
                        .collect(Collectors.toList()),
                new LotteryNumber(bonusNumber)
        );
    }

    public List<LotteryNumber> getAnswerNumber() {
        return answerNumber;
    }

    public LotteryNumber getBonusNumber() {
        return bonusNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotteryAnswer that = (LotteryAnswer) o;
        return Objects.equals(answerNumber, that.answerNumber) && Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(answerNumber, bonusNumber);
    }
}
