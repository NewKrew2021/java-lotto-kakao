package LottoMission;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Lotto implements Comparable<Lotto> {

    private final Set<Integer> numbers;
    private LotteryWinnings winnings;

    public Lotto(Set<Integer> numbers) {
        this.numbers = numbers;
    }

    public void compareToWinningNumber(Set<Integer> sixNumber, Integer bonus) {
        Set<Integer> combine = new HashSet<>(numbers);
        combine.addAll(sixNumber);
        int correctNo = 12 - combine.size();
        boolean hasBonusNo = numbers.contains(bonus);

        winnings = LotteryWinnings.getState(correctNo, hasBonusNo);
    }

    public LotteryWinnings getWinningsStat(){
        return this.winnings;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public int compareTo(Lotto lotto) {
        return Integer.compare(Objects.hash(this), Objects.hash(lotto));
    }

}
