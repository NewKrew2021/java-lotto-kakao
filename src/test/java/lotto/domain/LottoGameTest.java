package lotto.domain;

import lotto.dto.LottoStatisticDTO;
import lotto.exception.IllegalManualCountException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @ValueSource(ints = {-1, -2})
    public void validatePositiveCount(int count) {
        assertThatThrownBy(() -> {
            game.buyLotto(() -> lottoNumbers, count);
        }).isInstanceOf(IllegalManualCountException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3})
    public void validateExcessCount(int count) {
        assertThatThrownBy(() -> {
            game.buyLotto(() -> lottoNumbers, count);
        }).isInstanceOf(IllegalManualCountException.class);
    }

    @Test
    public void buyLottoOne() {
        UserBuyNumbers expected = game.buyLotto(()-> lottoNumbers, 1);

        UserBuyNumbers userBuyNumbers = new UserBuyNumbers();
        userBuyNumbers.addBuyNumbers(lottoNumbers);

        assertThat(userBuyNumbers).isEqualTo(expected);
    }

    @Test
    public void checkLotto() {
        game.buyLotto(() -> lottoNumbers, 1);
        WinningNumbers winningNumbers = new WinningNumbers("1, 2, 3, 4, 5, 6",7);

        LottoStatisticDTO lottoDTO = new LottoStatisticDTO();
        lottoDTO.setRankCount(Arrays.asList(0, 0, 0, 0, 0, 1));
        lottoDTO.setProfitRate((2000000000.0 - 1500.0)/ 1500.0);

        assertThat(game.checkLotto(winningNumbers).getRankCount()).isEqualTo(lottoDTO.getRankCount());
        assertThat(game.checkLotto(winningNumbers).getProfitRate()).isEqualTo(lottoDTO.getProfitRate());
    }
}