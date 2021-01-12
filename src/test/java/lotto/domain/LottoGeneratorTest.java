package lotto.domain;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {

    private LottoGenerator lottoGenerator;
    Lotto lotto;
    HashSet<Integer> set;

    @BeforeEach
    public void setUp() {
        lottoGenerator = LottoGenerator.getInstance();
    }

    @Test
    @DisplayName("서로다른 번호 6개로 로또번호가 생성된것인지 확인")
    public void lottoSizeTest() {
        Lotto lotto = lottoGenerator.generateLotto();;
        HashSet<Integer> set = new HashSet<>();
        lotto.getLotto().stream().forEach(number -> set.add(number.getNumber()));
        Assertions.assertTrue(lotto.getLotto().size()==6);
        Assertions.assertTrue(set.size()==6);
    }

    @Test
    @DisplayName("보너스 번호 유효성 검사")
    public void bonusNumberTest() {
        WonLotto wonlotto = lottoGenerator.generateWonLotto();;
        HashSet<Integer> set = new HashSet<>();
        wonlotto.getWonLotto().getLotto().stream().forEach(number -> set.add(number.getNumber()));
        set.add(wonlotto.getBonusNo());
        Assertions.assertTrue(set.size()==7);
    }

    @Test
    @DisplayName("String을 이용한 Lotto 생성 검사")
    public void textLottoGenerateTest() {
        Lotto lotto = lottoGenerator.lottoStringParser("1,2,3,4,5,6");
        assertThat(lotto.getLotto().size()).isEqualTo(6);
    }
}
