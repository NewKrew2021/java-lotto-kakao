package lotto.controller;

        import lotto.domain.LottoTickets;
        import lotto.domain.CreateTicket;
        import lotto.domain.WinningNumber;
        import lotto.view.InputView;
        import lotto.view.ResultView;

public class LottoGame {
    private static LottoTickets lottoTickets;
    private static WinningNumber winningNumber;

    public static void main(String[] argv){
        int price = InputView.inputPurchasePrice();

        setLottoTickets(price);
        winningNumber = new WinningNumber(InputView.winningNumber(), InputView.bonusNumber());

        ResultView.printResult(lottoTickets.getResults(winningNumber), price);
    }

    private static void setLottoTickets(int price) {
        ResultView.purchaseLottoNumber(price);
        lottoTickets = CreateTicket.createAutoTicket(price);
        ResultView.purchaseLottoTicket(lottoTickets);

    }
}

