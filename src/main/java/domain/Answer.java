package domain;

import utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Answer {

    private final List<Integer> answerNumbers;
    private final int bonusNumber;

    public Answer(String inputTexts, int bonusNumber) {
        this.answerNumbers = makeLottoNumberFromStrings(StringUtils.splitText(inputTexts));
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> makeLottoNumberFromStrings(List<String> strings) {
        return mapStringToInteger(strings);
    }

    private List<Integer> mapStringToInteger(List<String> strings) {
        List<Integer> results = new ArrayList<>();
        for (String string : strings) {
            addNumber(results, string);
        }
        return results;
    }

    private void addNumber(List<Integer> numbers, String string) {
        try {
            numbers.add(Integer.parseInt(string));
        } catch (NumberFormatException numberFormatException) {
            throw new NumberFormatException("숫자가 아닙니다.");
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> getAnswerNumbers() {
        return answerNumbers;
    }

}
