package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.stream.Collectors;

public class LottoNos {

    List<LottoNo> numbers = new ArrayList<>();

    public LottoNos(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("갯수는 6개 이어야 합니다.");
        }

        if (checkDuplication(numbers)) {
            throw new IllegalArgumentException("중복된 숫자가 존재하면 안됩니다.");
        }

        for (int number : numbers) {
            this.numbers.add(new LottoNo(number));
        }
    }

    private boolean checkDuplication(List<Integer> numbers) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.size(); i++) {
            set.add(numbers.get(i));
        }
        if (set.size() != numbers.size())
            return true;
        return false;
    }

    public boolean isContains(LottoNo lottoNo) {
        return this.numbers.contains(lottoNo);
    }

    public int getMatchCount(LottoNos lottoNos) {
        return this.numbers.stream()
                .filter((lottoNo) -> lottoNos.isContains(lottoNo))
                .collect(Collectors.toList())
                .size();
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }
}
