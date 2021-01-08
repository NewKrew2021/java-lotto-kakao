package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class BallFactory {

    public static final Map<Integer, Ball> ballBox = new HashMap<>();

    private BallFactory() {
    }

    public static Ball getBall(String ballString) {
        int ballNumber = checkInteger(ballString);
        checkRange(ballNumber);

        ballBox.putIfAbsent(ballNumber, new Ball(ballNumber));
        return ballBox.get(ballNumber);
    }

    private static int checkInteger(String ballString) {
        int ballNumber = 0;
        try {
            ballNumber = Integer.parseInt(ballString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("볼은 정수여야 한다.");
        }
        return ballNumber;
    }

    private static void checkRange(int ballNumber) {
        if (outOfRange(ballNumber)) {
            throw new IllegalArgumentException("볼은 1 이상 45 이하여야 한다.");
        }
    }

    private static boolean outOfRange(int ballNumber) {
        return 1 > ballNumber || ballNumber > 45;
    }
}
