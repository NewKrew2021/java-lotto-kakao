package lotto.view;

import lotto.domain.LottoMoney;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.input.BonusNumberValidInputGuaranteer;
import lotto.input.BuyingMoneyValidInputGuaranteer;
import lotto.input.WinningLottoNumsValidInputGuaranteer;

import java.util.List;
import java.util.Scanner;

public class LottoInputView {
    private static Scanner sc;

    static {
        sc = new Scanner(System.in);
    }

    public int getLottoCountFromUser() {
        LottoMoney moneyFromUser = new BuyingMoneyValidInputGuaranteer().getFromUser();
        return moneyFromUser.getLottoTicketCount();
    }

    public LottoNumbers inputWinningNumbers() {
        return new WinningLottoNumsValidInputGuaranteer().getFromUser();
    }

    public LottoNumber inputBonusNumber() {
        return new BonusNumberValidInputGuaranteer().getFromUser();
    }
}
