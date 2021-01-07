package domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {

    private List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        stringBuffer.append(lottoNumbers.stream().map(Object::toString).collect(Collectors.joining(",")));
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

}
