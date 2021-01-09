package lotto.view;

import lotto.Constant;
import lotto.domain.LottoNo;
import lotto.domain.LottoNos;
import lotto.input.BonusNumberValidInputGuaranteer;
import lotto.input.BuyingMoneyValidInputGuaranteer;
import lotto.input.WinningLottoNumsValidInputGuaranteer;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoInputView {
    private static Scanner sc;
    static {
        sc = new Scanner(System.in);
    }

    public int getLottoCountFromUser() {
        return Integer.parseInt(new BuyingMoneyValidInputGuaranteer().getFromUser()) / Constant.LOTTO_PRICE;
    }

    public List<Integer> inputWinningNumbers() {
        return Arrays.asList(new WinningLottoNumsValidInputGuaranteer().getFromUser().split(","))
                .stream()
                .map((String ballNumber) -> ballNumber.trim())
                .map((String ballNumber) -> Integer.parseInt(ballNumber))
                .collect(Collectors.toList());
    }

    public int inputBonusNumber() {
        return Integer.parseInt(new BonusNumberValidInputGuaranteer().getFromUser());
    }
}
