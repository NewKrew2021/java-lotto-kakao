package lotto.domain;

import java.util.Set;

public class BallCountChecker {
    private static final int BALL_COUNT = 6;

    public static void checkBallCount(Set<Number> numbers) {
        if(numbers.size() != BALL_COUNT) {
            throw new IllegalArgumentException("로또 번호는 6개만 입력해 주세요.");
        }
    }

}
