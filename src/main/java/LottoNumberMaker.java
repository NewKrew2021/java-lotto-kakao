import java.util.List;

public class LottoNumberMaker {

    public List<Integer> generateLottoNumbers(LottoStrategy lottoStrategy) {
        return lottoStrategy.NumberChoose();
    }
}
