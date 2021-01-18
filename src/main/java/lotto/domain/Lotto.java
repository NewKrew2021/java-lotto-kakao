package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    public static final int LOTTO_NUMBER_COUNT = 6;
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("6자리 숫자가 아닙니다.");
        }
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto() {
        this.lottoNumbers = LottoNumber.generateLottoNumbers(LOTTO_NUMBER_COUNT);
    }

    public Lotto(String lotto) {
        String[] lottoNumber = lotto.split(",");
        if (lottoNumber.length != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("6자리 숫자가 아닙니다");
        }
        this.lottoNumbers = new ArrayList<>();
        for (String number : lottoNumber) {
            validateDuplicate(LottoNumber.of(number.trim()));
            lottoNumbers.add(LottoNumber.of(number.trim()));
        }
    }

    public void validateDuplicate(LottoNumber lottoNumber) {
        if (contain(lottoNumber)) {
            System.out.println("중복");
            throw new IllegalArgumentException("중복된 숫자가 입력되었습니다");
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public int checkSameCount(Lotto userLotto) {
        int count = 0;
        for (LottoNumber number : userLotto.getLottoNumbers()) {
            count += contain(number) ? 1 : 0;
        }
        return count;
    }

    public boolean contain(LottoNumber number) {
        return lottoNumbers.contains(number);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append('[');
        str.append(lottoNumbers.stream().map(Object::toString).collect(Collectors.joining(", ")));
        str.append("]\n");
        return str.toString();
    }

}
