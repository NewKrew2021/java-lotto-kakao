package lotto.domain;

import lotto.dto.LottoStatisticDTO;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class LottoGameTest {

    @Test
    public void create() {
        LottoGame game = new LottoGame(new Money(14000));
        assertThat(game).isEqualTo(new LottoGame(new Money(14000)));
    }

    @Test
    public void buyLottoOne() {
        LottoGame game = new LottoGame(new Money(1500));
        UserBuyNumbers expected = game.buyLotto(()-> new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));

        UserBuyNumbers userBuyNumbers = new UserBuyNumbers();
        userBuyNumbers.addBuyNumbers(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));

        assertThat(userBuyNumbers).isEqualTo(expected);
    }

    @Test
    public void checkLotto() {
        LottoGame game = new LottoGame(new Money(1500));
        game.buyLotto(()-> new LottoNumbers(Arrays.asList(1,2,3,4,5,6)));
        WinningNumbers winningNumbers = new WinningNumbers("1, 2, 3, 4, 5, 6",7);
        LottoStatisticDTO lottoDTO = new LottoStatisticDTO();
        lottoDTO.setRankCount(Arrays.asList(0, 0, 0, 0, 0, 1));
        lottoDTO.setProfitRate((2000000000.0 - 1500.0)/ 1500.0);
        assertThat(game.checkLotto(winningNumbers).getRankCount()).isEqualTo(lottoDTO.getRankCount());
        assertThat(game.checkLotto(winningNumbers).getProfitRate()).isEqualTo(lottoDTO.getProfitRate());
    }
}