package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {
    Lotto lotto;

    @BeforeEach
    void setUp(){
        lotto = LottoGenerator.generateLotto();
    }

    @Test
    void testUnableToAdd(){
        lotto.getLotto().clear();
        assertThat(lotto.getLotto().size()).isNotEqualTo(0);
    }
}
