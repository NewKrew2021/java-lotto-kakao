package lotto.controller;

public class Main {
    public static void main(String[] args) {
        LottoMachine machine = new LottoMachine();
        machine.inputUserMoney();
        machine.inputManualTicketCount();
        machine.purchasingManually();
        machine.purchasingRemainsAutomatically();
        machine.printAllPurchasedLotto();
        machine.inputWinnerInformation();
        machine.outputStatisticsAboutPurchasedLotto();
    }
}
