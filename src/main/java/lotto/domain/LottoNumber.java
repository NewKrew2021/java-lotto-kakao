package lotto.domain;

import lotto.util.StringUtils;

import static lotto.util.StringUtils.*;

public class LottoNumber implements Comparable<LottoNumber>{
    private int number;

    public static int LOTTO_MIN_NUMBER = 1;
    public static int LOTTO_MAX_NUMBER = 45;

    private LottoNumber(int number){
        this.number = number;
    }

    public static LottoNumber makeNumberFromText(String text){
        if(isBlank(text) || !isNumber(text))
            throw new IllegalArgumentException("숫자를 입력해주세요.");

        return makeNumber(Integer.parseInt(text));
    }

    public static LottoNumber makeNumber(int number){
        if(number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER)
            throw new IllegalArgumentException("범위에 해당하지 않는 수입니다.");

        return new LottoNumber(number);
    }

    public final int getNumber(){
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    public boolean equals(int n){
        return number == n;
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.number - o.number;
    }
}
