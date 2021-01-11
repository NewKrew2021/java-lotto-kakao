package lotto.domain;

import lotto.domain.Lotto;
import lotto.util.RandomUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class LottoGenerator {

    private static List<Integer> allLottoNumbers = new ArrayList<>();
    public static LottoGenerator instance = null;

    public static final int LOTTO_MAX_SIZE = 6;

    private LottoGenerator(){
        for (int i = LottoNumber.LOTTO_MIN_NUMBER; i <= LottoNumber.LOTTO_MAX_NUMBER; i++) {
            allLottoNumbers.add(i);
        }
    }

    public static LottoGenerator getInstance(){
        if(instance == null)
            return new LottoGenerator();

        return instance;
    }

    public Lotto generateLotto() {

        List<Integer> lotto = new ArrayList<>();

        Collections.shuffle(allLottoNumbers);

        for (int i = 0; i < LOTTO_MAX_SIZE; i++) {
            lotto.add(allLottoNumbers.get(i));
        }

        return new Lotto(lotto);
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
