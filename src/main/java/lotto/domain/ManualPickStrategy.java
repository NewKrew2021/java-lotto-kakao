package lotto.domain;

import lotto.domain.vo.LottoNumber;
import lotto.view.InputView;

import java.util.List;

public class ManualPickStrategy implements NumberPickStrategy {

    @Override
    public List<LottoNumber> generateLottoNumbers() {
        return new InputView().scanTicket();
    }
}
