package lottoMission.domain;

import lottoMission.util.RandomForLotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private UserMoney userMoney;
    private TryNumber tryNumber;

    private final int LOTTO_PRICE = 1000;

    public LottoGame(int userMoney){
        this.userMoney = new UserMoney(userMoney);
        this.tryNumber = new TryNumber(userMoney/LOTTO_PRICE);
    }

    public Lottos buyLottosAuto(){
        List<Lotto> lottoList = new ArrayList<>();
        while(this.tryNumber.canTry()){
            lottoList.add(new Lotto(RandomForLotto.getRandomSixIntegerList()));
            this.tryNumber.useTryNumberCount();
        }
        return new Lottos(lottoList);
    }

    public int getUserMoney() {
        return userMoney.getUserMoney();
    }
}
