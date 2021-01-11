package lotto.domain;

import lotto.domain.Lotto;
import lotto.util.RandomUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {

    private static List<LottoNumber> allLottoNumbers =
            IntStream.rangeClosed(
                    LottoNumber.LOTTO_MIN_NUMBER,
                    LottoNumber.LOTTO_MAX_NUMBER)
            .mapToObj(number -> LottoNumber.makeNumber(number))
            .collect(Collectors.toList());
    public static LottoGenerator instance = null;

    public static final int LOTTO_MAX_SIZE = 6;

    private LottoGenerator(){
    }

    public static LottoGenerator getInstance(){
        if(instance == null)
            return new LottoGenerator();

        return instance;
    }

    public Lotto generateLotto() {

        Collections.shuffle(allLottoNumbers);

        return new Lotto(
                allLottoNumbers.stream()
                .limit(LOTTO_MAX_SIZE)
                .collect(Collectors.toList()));
    }

    public int generateBonus(Lotto lotto){
        HashSet<Integer> set = new HashSet<>();
        lotto.getLotto().stream().forEach(number -> set.add(number.getNumber()));

        int bonusNo = RandomUtil.getRandomValue();
        while(!set.add(bonusNo)){
            bonusNo = RandomUtil.getRandomValue();
        }

        return bonusNo;
    }

    public Lotto lottoStringParser(String lotto){

        String[] lottoNumber=lotto.split(",");
        List<LottoNumber> parsedLotto=new ArrayList<>();
        for (String number : lottoNumber) {
            parsedLotto.add(LottoNumber.makeNumber(Integer.parseInt(number.trim())));
        }
        return new Lotto(parsedLotto);
    }


}
