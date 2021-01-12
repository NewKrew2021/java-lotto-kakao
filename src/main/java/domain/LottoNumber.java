package domain;

import domain.exceptions.InvalidLottoNumberException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

  static final int LOWER_BOUND = 1;
  static final int UPPER_BOUND = 45;
  static final List<LottoNumber> numbers;
  static {
    numbers = new ArrayList<>();
    for (int i = 0; i <= UPPER_BOUND; i++) {
      numbers.add(new LottoNumber(i));
    }
  }

  private final int number;

  public static LottoNumber of(Integer number) {
    validateRange(number);
    LottoNumber lottoNumber = numbers.get(number);
    return lottoNumber;
  }

  private LottoNumber(Integer number) {
    this.number = number;
  }

  private static void validateRange(Integer number) {
    if (number == null) {
      throw new InvalidLottoNumberException("null 입력 에러");
    }

    if (number < LOWER_BOUND || number > UPPER_BOUND) {
      throw new InvalidLottoNumberException("1~45 사이의 숫자만 입력해주세요.");
    }
  }

  public int getNumber() {
    return number;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LottoNumber that = (LottoNumber) o;
    return number == that.number;
  }

  @Override
  public int hashCode() {
    return Objects.hash(number);
  }

  @Override
  public int compareTo(LottoNumber other) {
    return this.number - other.getNumber();
  }
}
