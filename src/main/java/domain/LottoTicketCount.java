package domain;

import domain.exceptions.InvalidLottoCountException;
import java.util.Objects;

public class LottoTicketCount {

  private final int manualCount;
  private final int autoCount;

  public LottoTicketCount(Amount amount, int manualCount) {
    int count = amount.getCount();
    validate(manualCount, count);
    this.manualCount = manualCount;
    this.autoCount = count - manualCount;
  }

  private void validate(int manualCount, int count) {
    if (count < manualCount) throw new InvalidLottoCountException("수동 구매 개수는 총 구매 개수를 넘을 수 없습니다.");
  }

  public int getManualCount() {
    return manualCount;
  }

  public int getAutoCount() {
    return autoCount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LottoTicketCount that = (LottoTicketCount) o;
    return manualCount == that.manualCount && autoCount == that.autoCount;
  }

  @Override
  public int hashCode() {
    return Objects.hash(manualCount, autoCount);
  }
}
