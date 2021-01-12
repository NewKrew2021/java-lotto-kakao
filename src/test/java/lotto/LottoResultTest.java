package lotto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LottoResultTest {
    @Test
    void getResult(){
        assertEquals(LottoResult.FIRST, LottoResult.getResult(6, true));
        assertEquals(LottoResult.FIRST, LottoResult.getResult(6, false));
        assertEquals(LottoResult.SECOND, LottoResult.getResult(5, true));
        assertEquals(LottoResult.THIRD, LottoResult.getResult(5, false));
        assertEquals(LottoResult.FOURTH, LottoResult.getResult(4, true));
        assertEquals(LottoResult.FOURTH, LottoResult.getResult(4, false));
        assertEquals(LottoResult.FIFTH, LottoResult.getResult(3, true));
        assertEquals(LottoResult.FIFTH, LottoResult.getResult(3, false));
    }
}
