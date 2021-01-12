package domain;

import domain.exceptions.InvalidAmountException;
import java.util.Objects;

public class Amount {

  private static final int LOTTO_PRICE = 1000;

  private final int amount;

  public Amount(int amount) {
    validate(amount);
    this.amount = amount;
  }

  private void validate(int amount) {
    if (amount < LOTTO_PRICE) {
      throw new InvalidAmountException("구입금액이 부족합니다.");
    }
  }

  public int getAmount() {
    return amount;
  }

  public int getCount() {
    return this.amount / LOTTO_PRICE;
  }

  @Override
  public boolean equals(Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
    Amount amount1 = (Amount) o;
    return amount == amount1.amount;
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount);
  }
}
