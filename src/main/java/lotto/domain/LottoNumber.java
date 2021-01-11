package lotto.domain;

import java.util.Objects;

public class LottoNumber {
    private int number;

    public static int LOTTO_MIN_NUMBER = 1;
    public static int LOTTO_MAX_NUMBER = 45;

    private LottoNumber(int number){
        this.number = number;
    }

    public static LottoNumber makeNumberFromText(String text){
        if(isBlank(text) || !isNumber(text))
            throw new RuntimeException("숫자를 입력해주세요.");

        return new LottoNumber(Integer.parseInt(text));
    }

    public static LottoNumber makeNumber(int number){
        if(number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER)
            throw new RuntimeException("범위에 해당하지 않는 수입니다.");

        return new LottoNumber(number);
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

    public static boolean isBlank(String text){
        return text.isEmpty() || text == null;
    }

    public static boolean isNumber(String text){
        try{
           Integer.parseInt(text);
           return true;
        }catch (Exception e){
            return false;
        }
    }
}
