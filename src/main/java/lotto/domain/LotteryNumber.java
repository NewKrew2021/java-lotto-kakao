package lotto.domain;

import java.util.HashMap;
import java.util.Objects;

public class LotteryNumber {
    public static final int MIN_LOTTERYNUMBER = 1;
    public static final int MAX_LOTTERYNUMBER = 45;
    private static final String MSG_WRONG_LOTTERYNUMBER_RANGE = String.format(
            "로또 번호는 %d와 %d 사이의 수여야 합니다.", MIN_LOTTERYNUMBER, MAX_LOTTERYNUMBER);

    private static final HashMap<Integer, LotteryNumber> hashMap = new HashMap<Integer, LotteryNumber>();
    static{
        for (int i = MIN_LOTTERYNUMBER; i <= MAX_LOTTERYNUMBER; i++) {
            hashMap.put(i, new LotteryNumber(i));
        }
    }

    private final int number;

    public static LotteryNumber of(int number){
        if (number < MIN_LOTTERYNUMBER || number > MAX_LOTTERYNUMBER) {
            throw new IllegalArgumentException(MSG_WRONG_LOTTERYNUMBER_RANGE);
        }
        return hashMap.get(number);
    }

    private LotteryNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotteryNumber that = (LotteryNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }


}
