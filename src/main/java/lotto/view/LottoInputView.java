package lotto.view;

import lotto.domain.LottoMoney;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.input.*;

import java.util.ArrayList;
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

    public int inputSelfLottoCount(){
        return new SelfLottoCountValidInputGuaranteer().getFromUser();
    }

    public List<LottoNumbers> getSelfTickets(int count){
        System.out.println("수동으로 구매할 로또 번호를 입력해 주세요.");
        List<LottoNumbers> tickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            tickets.add(new LottoNumsValidInputGuaranteer().getFromUser());
        }
        return tickets;
    }
}
