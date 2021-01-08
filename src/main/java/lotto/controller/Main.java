package lotto.controller;

public class Main {
    public static void main(String[] args){
        LottoMachine machine = new LottoMachine();
        machine.inputPrice();
        machine.generateAuto();
        machine.outputAboutPurchasedLotto();
        machine.inputWinnerInformation();
        machine.outputStatisticsAboutPurchasedLotto();
    }
}
