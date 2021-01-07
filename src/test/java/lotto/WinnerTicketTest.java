package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerTicketTest {
    @DisplayName("당첨 로또 번호와 보너스 넘버가 주어지면 당첨 티켓 생성한다.")
    @Test
    void create() {
        //given
        LottoNumbers lottoNumbers = LottoNumbers.from(new OneToSixGenerator());
        LottoNumber bonusNumber = new LottoNumber(7);

        //when
        WinnerTicket winnerTicket = new WinnerTicket(lottoNumbers, bonusNumber);

        //then
        List<LottoNumber> expected = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        assertThat(winnerTicket.getWinnerNumbers().getLottoNumbers()).isEqualTo(expected);
        assertThat(winnerTicket.getBonusNumber()).isEqualTo(new LottoNumber(7));
    }

}
