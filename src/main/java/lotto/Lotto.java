package lotto;

import java.util.*;

public class Lotto {
    private Set<LottoNumber> lottoNumbers;

    public Lotto(LottoNumberGenerator lottoNumberGenerator){
        lottoNumbers = new HashSet<>();
        for (int l : lottoNumberGenerator.getNumbers()) {
            lottoNumbers.add(LottoNumber.of(l));
        }
    }

    public Lotto() {
        lottoNumbers = new HashSet<>();
        LottoNumberGenerator lottoNumberGenerator = new FixNumberGenerator();
        for (int l : lottoNumberGenerator.getNumbers()) {
            lottoNumbers.add(LottoNumber.of(l));
        }
    }

    public boolean isContain(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }
}
