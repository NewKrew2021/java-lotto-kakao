package lotto.domain;

import lotto.dto.LottoNumberData;
import lotto.setting.Format;

import java.util.*;

public class LottoPaperGenerator {
    private final int inputMoney;

    public LottoPaperGenerator(int inputMoney){
        this.inputMoney = inputMoney;
    }

    public LottoPaper generateAuto() {
        List<Set<Integer>> numbers = new ArrayList<>();
        Random random = new Random();

        for(int i = 0; i < inputMoney / Format.TICKET_PRICE; i++) {
            numbers.add(getAutomaticallyGeneratedNumbers(random));
        }

        return generateManually(new LottoNumberData(numbers));
    }

    private Set<Integer> getAutomaticallyGeneratedNumbers(Random random) {
        Set<Integer> genNumbers = new HashSet<>();

        do {
            genNumbers.add(random.nextInt(Format.UPPER_LIMIT_OF_NUMBER) + 1);
        } while (genNumbers.size() < 6);

        return genNumbers;
    }

    public LottoPaper generateManually(LottoNumberData enteredNumber){
        return new LottoPaper(enteredNumber);
    }
}