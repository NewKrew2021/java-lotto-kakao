package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumberMaker {

    public List<Integer> generateLottoNumbers(LottoStrategy lottoStrategy) {
        return lottoStrategy.choose6Numbers();
    }

    public List<Integer> makeLottoNumberFromStrings(List<String> strings) {
        return mapStringToInteger(strings);
    }

    private List<Integer> mapStringToInteger(List<String> strings) {
        List<Integer> results = new ArrayList<>();
        for (String string : strings) {
            addNumberIfCanConvertToInt(results, string);
        }
        return results;
    }

    private void addNumberIfCanConvertToInt(List<Integer> numbers, String string) {
        try {
            numbers.add(Integer.parseInt(string));
        } catch (NumberFormatException numberFormatException) {
            throw new NumberFormatException("숫자가 아닙니다.");
        }
    }
}
