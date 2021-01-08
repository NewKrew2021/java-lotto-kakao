package lotto.domain;

public class NumberGenerator {

    public static LottoNumbers generateBuyNumbers(GenerateStrategy gs) {
        return gs.generate();
    }
}
