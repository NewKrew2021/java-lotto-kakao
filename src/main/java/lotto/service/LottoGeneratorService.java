package lotto.service;

import lotto.domain.Lotto;
import lotto.util.RandomUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class LottoGeneratorService {

    public Lotto generateLotto() {

        List<Integer> lotto = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        while (set.size() < 6) {
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

    public int generateBonus(Lotto lotto){
        HashSet<Integer> set = new HashSet<>();
        set.addAll(lotto.getLotto());

        int bonusNo = RandomUtil.getRandomValue();
        while(!set.add(bonusNo)){
            bonusNo = RandomUtil.getRandomValue();
        }

        return bonusNo;
    }

    public Lotto lottoStringParser(String lotto){

        String[] lottoNumber=lotto.split(",");
        List<Integer> parsedLotto=new ArrayList<>();
        for (String number : lottoNumber) {
            parsedLotto.add(Integer.parseInt(number.trim()));
        }
        return new Lotto(parsedLotto);
    }


}
