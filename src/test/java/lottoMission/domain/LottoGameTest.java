package lottoMission.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    @Test
    public void 유저머니테스트(){
        LottoGame lottoGame = new LottoGame(5000);
        assertThat(lottoGame.getUserMoney()).isEqualTo(5000);
    }
}
