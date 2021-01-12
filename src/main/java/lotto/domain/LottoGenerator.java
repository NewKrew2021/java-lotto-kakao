package lotto.domain;

import lotto.domain.Lotto;
import lotto.util.RandomUtil;

import java.util.*;
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

        SortedSet<LottoNumber> set = new TreeSet<>();
        set.addAll(allLottoNumbers.subList(0, LOTTO_MAX_SIZE));

        return new Lotto(set);
    }

    public WonLotto generateWonLotto(){
        Collections.shuffle(allLottoNumbers);

        SortedSet<LottoNumber> set = new TreeSet<>();
        set.addAll(allLottoNumbers.subList(0, LOTTO_MAX_SIZE));

        return new WonLotto(new Lotto(set), allLottoNumbers.get(LOTTO_MAX_SIZE).getNumber());
    }

    public Lotto lottoStringParser(String lotto){

        String[] lottoNumber=lotto.split(",");
        SortedSet<LottoNumber> parsedLotto=new TreeSet<>();
        for (String number : lottoNumber) {
            parsedLotto.add(LottoNumber.makeNumber(Integer.parseInt(number.trim())));
        }
        return new Lotto(parsedLotto);
    }


}
