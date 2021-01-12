package lotto.domain;

public class NumberGenerator {

    public static LottoNumbers generateBuyNumbers(GenerateStrategy generateStrategy) {
        return generateStrategy.generate();
    }
}
