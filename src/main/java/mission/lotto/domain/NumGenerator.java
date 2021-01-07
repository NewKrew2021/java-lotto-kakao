package mission.lotto.domain;

import java.util.List;

@FunctionalInterface
public interface NumGenerator {

    List<Integer> getSixNumbers();

}
