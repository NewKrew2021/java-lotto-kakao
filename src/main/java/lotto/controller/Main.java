package lotto.controller;

public class Main {
    public static void main(String[] args) {
        LottoMachine machine = new LottoMachine();
        machine.processForInputPrice();
        machine.processForPurchasingManually();
        machine.processForPurchasingRemains();
        machine.processForPrintingAllPurchasedLotto();
        machine.inputWinnerInformation();
        machine.outputStatisticsAboutPurchasedLotto();
    }
}
