package lotto.domain;

import java.util.List;

@FunctionalInterface
public interface GenerateStrategy {
    List<String> generate();
}
