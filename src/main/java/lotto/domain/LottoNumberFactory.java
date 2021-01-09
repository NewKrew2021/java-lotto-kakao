package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoNumberFactory {

    public static final Map<Integer, LottoNumber> lottoNumberBox = new HashMap<>();

    private LottoNumberFactory() {
    }

    public static LottoNumber getLottoNumber(String lottoNumberString) {
        int lottoNumber = checkInteger(lottoNumberString);
        checkRange(lottoNumber);

        lottoNumberBox.putIfAbsent(lottoNumber, new LottoNumber(lottoNumber));
        return lottoNumberBox.get(lottoNumber);
    }

    private static int checkInteger(String lottoNumberString) {
        int lottoNumber = 0;
        try {
            lottoNumber = Integer.parseInt(lottoNumberString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("볼은 정수여야 한다.");
        }
        return lottoNumber;
    }

    private static void checkRange(int lottoNumber) {
        if (outOfRange(lottoNumber)) {
            throw new IllegalArgumentException("볼은 1 이상 45 이하여야 한다.");
        }
    }

    private static boolean outOfRange(int lottoNumber) {
        return 1 > lottoNumber || lottoNumber > 45;
    }
}
