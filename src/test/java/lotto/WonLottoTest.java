package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class WonLottoTest {


    private WonLotto wonLotto;

    @BeforeEach
    void setUp(){
        wonLotto = new WonLotto();
    }

    @Test
    @DisplayName("서로다른 번호 7개로 당첨번호가 생성된것인지 확인")
    void testWonLottoSize(){

        HashSet<Integer> set = new HashSet<>();
        set.addAll(wonLotto.getWonLotto().getLotto());
        Assertions.assertTrue(set.size()==6);

        set.add(wonLotto.getBonusNo());
        Assertions.assertTrue(set.size()==7);
    }
}
