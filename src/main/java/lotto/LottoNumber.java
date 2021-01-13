package lotto;

public class LottoNumber {
    static final int MAX_LOTTO_NUMBER = 45;
    static final int MIN_LOTTO_NUMBER = 1;
    private final int number;
    private static final LottoNumber[] LIST = new LottoNumber[MAX_LOTTO_NUMBER + 1];

    static {
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            LIST[i] = new LottoNumber(i);
        }
    }

    public static LottoNumber of(int number) {
        validation(number);
        return LIST[number];
    }

    private LottoNumber(int number) {
        this.number = number;
    }

    private static void validation(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("Lotto number should be between 1 to 45.");
        }
    }

    public int getNumber() {
        return number;
    }
}
