package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoTest {

    private Lotto lotto;

    @BeforeEach
    void setUp(){
        List<LottoNumber> pcLottoNumber=Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5),new LottoNumber(6));
        lotto=new Lotto(pcLottoNumber);
    }

    @Test
    public void testLottoSizeException(){
        List<LottoNumber> smallLotto=Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5));
        List<LottoNumber> bigLotto=Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5),new LottoNumber(6),new LottoNumber(7));

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(()->new Lotto(smallLotto));
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(()->new Lotto(bigLotto));

    }

    @Test
    public void testSameCountZero(){

        List<LottoNumber> userLottoNumber=Arrays.asList(new LottoNumber(12), new LottoNumber(7), new LottoNumber(8), new LottoNumber(9), new LottoNumber(10),new LottoNumber(11));
        Lotto userLotto=new Lotto(userLottoNumber);
        Assertions.assertTrue(lotto.checkSameCount(userLotto)==0);
    }

    @Test
    public void testSameCountOne(){

        List<LottoNumber> userLottoNumber=Arrays.asList(new LottoNumber(1), new LottoNumber(7), new LottoNumber(8), new LottoNumber(9), new LottoNumber(10),new LottoNumber(11));
        Lotto userLotto=new Lotto(userLottoNumber);
        Assertions.assertTrue(lotto.checkSameCount(userLotto)==1);
    }

    @Test
    public void testSameCountTwo(){

        List<LottoNumber> userLottoNumber=Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(8), new LottoNumber(9), new LottoNumber(10),new LottoNumber(11));
        Lotto userLotto=new Lotto(userLottoNumber);
        Assertions.assertTrue(lotto.checkSameCount(userLotto)==2);
    }

    @Test
    public void testSameCountThree(){

        List<LottoNumber> userLottoNumber=Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(9), new LottoNumber(10),new LottoNumber(11));
        Lotto userLotto=new Lotto(userLottoNumber);
        Assertions.assertTrue(lotto.checkSameCount(userLotto)==3);
    }


    @Test
    public void testSameCountFour(){

        List<LottoNumber> userLottoNumber=Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(10),new LottoNumber(11));
        Lotto userLotto=new Lotto(userLottoNumber);
        Assertions.assertTrue(lotto.checkSameCount(userLotto)==4);
    }

    @Test
    public void testSameCountFive(){

        List<LottoNumber> userLottoNumber=Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5),new LottoNumber(11));
        Lotto userLotto=new Lotto(userLottoNumber);
        Assertions.assertTrue(lotto.checkSameCount(userLotto)==5);
    }

    @Test
    public void testSameCountSix(){

        List<LottoNumber> userLottoNumber=Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5),new LottoNumber(6));
        Lotto userLotto=new Lotto(userLottoNumber);
        Assertions.assertTrue(lotto.checkSameCount(userLotto)==6);
    }

    @Test
    public void testContain(){
        Assertions.assertTrue(lotto.contain(new LottoNumber(1))==1);
        Assertions.assertTrue(lotto.contain(new LottoNumber(13))==0);

    }
}
