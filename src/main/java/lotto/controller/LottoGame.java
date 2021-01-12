package lotto.controller;

        import lotto.domain.LottoTickets;
        import lotto.domain.CreateTicket;
        import lotto.domain.WinningNumber;
        import lotto.view.InputView;
        import lotto.view.ResultView;

public class LottoGame {
    public static void main(String[] argv) {
        int price = InputView.inputPurchasePrice();

        LottoTickets lottoTickets = new LottoTickets(CreateTicket.createAutoTicket(price));
        ResultView.purchaseLottoTicket(lottoTickets);

        WinningNumber winningNumber = new WinningNumber(InputView.winningNumber(), InputView.bonusNumber());
        ResultView.printResult(lottoTickets.getResults(winningNumber), price);
    }
}

