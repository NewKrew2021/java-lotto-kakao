package domain;

import utils.StringUtils;

import java.util.List;

public class SelfLottoStrategy implements LottoStrategy{

    private String inputText;

    public SelfLottoStrategy(String inputText) {
        this.inputText = inputText;
    }

    @Override
    public List<Integer> numberChooseStrategy() {
        return StringUtils.mapStringListToIntegerList(inputText);
    }
}
