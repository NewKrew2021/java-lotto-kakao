package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.List;

public class LottoGeneratorService {

    public Lotto lottoStringParser(String lotto) {
        String[] lottoNumber = lotto.split(",");
        List<LottoNumber> parsedLotto = new ArrayList<>();
        try {
            convertList(lottoNumber, parsedLotto);
            return new Lotto(parsedLotto);
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 입력형식입니다");
        }
    }

    private void convertList(String[] lottoNumber, List<LottoNumber> parsedLotto) {
        for (String number : lottoNumber) {
            parsedLotto.add(new LottoNumber(Integer.parseInt(number.trim())));
        }
    }

}
