package lotto.domain;

import lotto.dto.LottoStatisticDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class LottoGameTest {

    LottoGame game;
    LottoNumbers lottoNumbers;

    @BeforeEach
    void setUp() {
        game = new LottoGame(new Money(1500));
        lottoNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    public void createEqualInstance() {
        assertThat(game).isEqualTo(new LottoGame(new Money(1500)));
    }

    @Test
    public void buyLottoOne() {
        UserBuyNumbers expected = game.buyLotto(()-> lottoNumbers);

        UserBuyNumbers userBuyNumbers = new UserBuyNumbers();
        userBuyNumbers.addBuyNumbers(lottoNumbers);

        assertThat(userBuyNumbers).isEqualTo(expected);
    }

    @Test
    public void checkLotto() {
        game.buyLotto(() -> lottoNumbers);
        WinningNumbers winningNumbers = new WinningNumbers("1, 2, 3, 4, 5, 6",7);

        LottoStatisticDTO lottoDTO = new LottoStatisticDTO();
        lottoDTO.setRankCount(Arrays.asList(0, 0, 0, 0, 0, 1));
        lottoDTO.setProfitRate((2000000000.0 - 1500.0)/ 1500.0);

        assertThat(game.checkLotto(winningNumbers).getRankCount()).isEqualTo(lottoDTO.getRankCount());
        assertThat(game.checkLotto(winningNumbers).getProfitRate()).isEqualTo(lottoDTO.getProfitRate());
    }
}