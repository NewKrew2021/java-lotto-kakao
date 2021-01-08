package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoFixedValue;
import lotto.util.RandomUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class LottoGeneratorService {


    public Lotto generateLotto() {

        List<Integer> lotto = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        while (set.size() < LottoFixedValue.LOTTO_NUMBER_COUNT) {
            checkDuplicate(set, RandomUtil.getRandomValue(), lotto);
        }
        Collections.sort(lotto);
        return new Lotto(lotto);
    }

    public void checkDuplicate(HashSet<Integer> set, int randomNumber, List<Integer> lotto) {

        if (set.add(randomNumber)) {
            lotto.add(randomNumber);
        }
    }


    public Lotto lottoStringParser(String lotto) {

        String[] lottoNumber = lotto.split(",");
        List<Integer> parsedLotto = new ArrayList<>();
        try {
            convertList(lottoNumber, parsedLotto);
            return new Lotto(parsedLotto);
        } catch (Exception e) {
            return null;
        }

    }

    private void convertList(String[] lottoNumber, List<Integer> parsedLotto) {
        for (String number : lottoNumber) {
            parsedLotto.add(validateNumber(Integer.parseInt(number.trim()), parsedLotto));
        }
    }

    public int validateNumber(int number, List<Integer> parsedLotto) {
        if (parsedLotto.contains(number)) {
            throw new IllegalArgumentException("중복된 숫자입니다.");
        }
        return validateRange(number);
    }

    public int validateRange(int number) {

        if (number > LottoFixedValue.LOTTO_MAX_INT || number <= 0) {
            throw new IllegalArgumentException("로또 범위 밖의 숫자입니다.");
        }

        return number;
    }


}
