package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoLogic {
    private List<LottoNos> lottoTickets = new ArrayList<>();

    public LottoLogic(int howmany) {
        List<Integer> nums = makeLottoNumber();
        for (int i = 0; i < howmany; i++) {
            Collections.shuffle(nums);
            lottoTickets.add(new LottoNos(nums.subList(0, 6)));
        }
    }

    public int getLottoCount() {
        return lottoTickets.size();
    }

    private List<Integer> makeLottoNumber() {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            nums.add(i);
        }
        return nums;
    }


}
