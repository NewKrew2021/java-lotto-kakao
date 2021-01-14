package lotto.view;

import lotto.domain.*;

import lotto.dto.LottoStatisticDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class OutputViewTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    LottoGame lottoGame;
    LottoNumbers lottoNumbers1;
    LottoNumbers lottoNumbers2;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));

        lottoGame = new LottoGame(new Money(2000));
        lottoNumbers1 = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoNumbers2 = new LottoNumbers(Arrays.asList(5, 10, 15, 20, 25, 30));
    }

    @Test
    public void systemOut_lottoCount() {
        OutputView.printLottoCount(1, lottoGame);

        assertThat("수동으로 1장, 자동으로 1장을 구매했습니다.\n").isEqualTo(outputStreamCaptor.toString());
    }

    @Test
    public void systemOut_buyLotto() {
        UserBuyNumbers userBuyNumbers = new UserBuyNumbers();
        userBuyNumbers.addBuyNumbers(lottoNumbers1);
        userBuyNumbers.addBuyNumbers(lottoNumbers2);

        OutputView.printBuyLotto(userBuyNumbers);

        assertThat("[1, 2, 3, 4, 5, 6]\n[5, 10, 15, 20, 25, 30]\n\n").isEqualTo(outputStreamCaptor.toString());
    }

    @Test
    public void systemOut_result() {
        lottoGame.buyLotto(() -> lottoNumbers1, 1);
        lottoGame.buyLotto(() -> lottoNumbers2, 1);
        WinningNumbers winningNumbers = new WinningNumbers("1, 2, 3, 4, 5, 6",7);

        LottoStatisticDTO lottoDTO = new LottoStatisticDTO();
        LottoStatisticDTO lottoStatisticDTO = lottoGame.checkLotto(winningNumbers);

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("당첨 통계\n----------\n");
        stringBuffer.append("3개 일치 (5000원)- 0개\n4개 일치 (50000원)- 0개\n5개 일치 (1500000원)- 0개\n");
        stringBuffer.append("5개 일치, 보너스 볼 일치 (30000000원)- 0개\n6개 일치 (2000000000원)- 1개\n");
        stringBuffer.append("총 수익률은 999999.00 입니다.\n");

        OutputView.printResult(lottoStatisticDTO);

        assertThat(stringBuffer.toString()).isEqualTo(outputStreamCaptor.toString());
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }
}
