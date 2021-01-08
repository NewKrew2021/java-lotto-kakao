package lotto.domain;

import lotto.dto.LottoResultDTO;
import java.util.List;
import java.util.Objects;

public class LottoGame {

    private final Money money;
    private final UserBuyNumbers userBuyNumbers;

    public LottoGame(Money money) {
        this.money = money;
        this.userBuyNumbers = new UserBuyNumbers();
    }

    public List<List<String>> buyLotto(GenerateStrategy generateStrategy) {
        for (int i = 0; i < money.possibleNumberBuy(); i++) {
            userBuyNumbers.addBuyNumbers(NumberGenerator.generateBuyNumbers(generateStrategy));
        }
        return userBuyNumbers.convertToString();
    }

//    public LottoResultDTO checkLotto(WinAndBonusNumbers winAndBonusNumbers) {
//        LottoResult lottoResult = new LottoResult();
//        LottoResultDTO lottoResultDto = new LottoResultDTO();
//        lottoResultDto.setRankCount(lottoResult.checkLottoResult(this.totalUserBuyNumbers, winAndBonusNumbers));
//        lottoResultDto.setProfitRate(lottoResult.checkProfitRate(money));
//
////        lottoResult.setRankCount(totalUserBuyNumbers.checkLottoResult(winAndBonusNumbers));
////        lottoResult.setProfitRate(totalUserBuyNumbers.checkProfitRate(winAndBonusNumbers));
//        return lottoResult.getLottoResult();
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoGame lottoGame = (LottoGame) o;
        return Objects.equals(money, lottoGame.money) && Objects.equals(userBuyNumbers, lottoGame.userBuyNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(money, userBuyNumbers);
    }
}
