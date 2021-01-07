package lotto.domain;

public class NumberGenerator {

    public static UserBuyNumbers generateBuyNumbers(GenerateStrategy gs) {
        return gs.generate();
    }
}
