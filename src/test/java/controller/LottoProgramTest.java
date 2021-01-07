package controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class LottoProgramTest {

    private LottoProgram lottoProgram;

    @BeforeEach
    void setUp(){
        lottoProgram = new LottoProgram();
    }

    @Test
    void calculateBuyLottoCount() {
        assertThat(lottoProgram.calculateBuyLottoCount(new BigDecimal("14500"))).isEqualTo(14);
    }
}