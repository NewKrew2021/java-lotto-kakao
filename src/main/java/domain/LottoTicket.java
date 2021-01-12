package domain;

import domain.exceptions.InvalidLottoNumberException;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoTicket {

  public static final int LOTTO_NUMBERS_LENGTH = 6;

  private final List<LottoNumber> numbers;

  public LottoTicket(List<Integer> integerNumbers) {
    List<LottoNumber> numbers = Optional.ofNullable(integerNumbers)
        .orElseThrow(() -> new InvalidLottoNumberException("LottoTicket of List<Integer> null error"))
        .stream()
        .map(LottoNumber::of)
        .collect(Collectors.toList());

    validateLength(numbers);
    validateDuplicate(numbers);

    this.numbers = numbers;
  }

  private void validateDuplicate(List<LottoNumber> numbers) {
    Set<LottoNumber> numbersSet = new HashSet<>(numbers);
    validateLength(numbersSet);
  }

  private static void validateLength(Collection<LottoNumber> numbers) {
    if(numbers.size() != LOTTO_NUMBERS_LENGTH) {
      throw new InvalidLottoNumberException("로또 티켓을 생성하기위해선 6개의 숫자만 입력해야합니다.");
    }
  }

  public boolean isContains(LottoNumber number) {
    return numbers.contains(number);
  }

  public int getMatchedCount(LottoTicket lottoWinningTicket) {
    int count = 0;
    for (LottoNumber number : numbers) {
      count += lottoWinningTicket.isContains(number) ? 1 : 0;
    }

    return count;
  }

  public List<Integer> getLottoTicketInfo() {
    return numbers.stream()
        .map(LottoNumber::getNumber)
        .collect(Collectors.toList());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LottoTicket that = (LottoTicket) o;
    return Objects.equals(numbers, that.numbers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numbers);
  }
}
