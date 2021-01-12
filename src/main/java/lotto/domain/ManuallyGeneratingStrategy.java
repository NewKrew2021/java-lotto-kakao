package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ManuallyGeneratingStrategy implements GeneratingStrategy {
    private List<Set<Integer>> numberSets = new ArrayList<>();
    private int currentGenerationPosition = 0;

    /* 값 복사 */
    public ManuallyGeneratingStrategy(List<Set<Integer>> inputNumberSets) {
        for (Set<Integer> inputNumberSet : inputNumberSets) {
            numberSets.add(new HashSet<>(inputNumberSet));
        }
    }

    public Set<Integer> generate() {
        if(numberSets.size() <= currentGenerationPosition) {
            throw new ArrayIndexOutOfBoundsException("입력보다 더 많이 generate했습니다.");
        }
        return numberSets.get(currentGenerationPosition++);
    }

    public int getLimit() {
        return numberSets.size();
    }
}
