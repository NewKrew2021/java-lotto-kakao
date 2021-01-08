package lotto.dto;

import java.util.*;

public class LottoNumberData {

    private final List<Set<Integer>> numberData;

    public LottoNumberData(List<Set<Integer>> numberData){ //TODO: 보너스볼이 추첨번호에 포함되면 안된다. exception이 필요하다.
        this.numberData = numberData;
    }

    /* return copied numberData */
    public List<Set<Integer>> getNumberData(){
        List<Set<Integer>> copiedNumbers = new ArrayList<>();

        for(Set<Integer> currentLine : numberData){
            copiedNumbers.add(copyingLine(currentLine));
        }

        return copiedNumbers;
    }

    private Set<Integer> copyingLine(Set<Integer> currentLine){
        return new HashSet<>(currentLine);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumberData)) return false;
        LottoNumberData lottoNumberData = (LottoNumberData) o;
        return Objects.equals(numberData, lottoNumberData.numberData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberData);
    }
}
