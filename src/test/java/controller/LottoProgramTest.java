package controller;

import exception.ManualLottoCountExceededException;
import exception.UnderLottoBuyAmountException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoProgramTest {

    private LottoProgram lottoProgram;

    @BeforeEach
    void setUp() {
        lottoProgram = new LottoProgram();
    }

    @Test
    void checkBuyAmount() {
        assertThatThrownBy(() -> {
            lottoProgram.checkBuyAmount(900);
        }).isInstanceOf(UnderLottoBuyAmountException.class);
    }

    @Test
    @DisplayName("수동 구입 갯수에 대한 예외 상황 테스트")
    void calculateAutoBuyLottoCount() {
        assertThatThrownBy(() -> {
            lottoProgram.calculateAutoBuyLottoCount(10000, 12);
        }).isInstanceOf(ManualLottoCountExceededException.class);

        assertThat(lottoProgram.calculateAutoBuyLottoCount(10000, 9)).isEqualTo(1);
    }
}