package domain;

import java.util.List;

@FunctionalInterface
public interface LottoStrategy {
    List<Integer> choose6Numbers();
}
