package domain;

import java.util.List;

@FunctionalInterface
public interface LottoStrategy {
    List<Integer> NumberChooseStrategy();
}
