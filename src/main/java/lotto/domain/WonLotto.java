package lotto.domain;

import lotto.service.LottoGeneratorService;

public class WonLotto {

    private final Lotto wonLotto;
    private final LottoNumber bonusNo;

    private LottoGeneratorService lottoGeneratorService = new LottoGeneratorService();

    private final int NON_GRADE_NUMBER = 3;
    private final int BONUS_NUMBER_MATCHING_COUNT = 5;


    public WonLotto(Lotto lotto, LottoNumber bonusNo) {
        this.wonLotto = lotto;
        this.bonusNo = bonusNo;
    }

    public Lotto getWonLotto() {
        return wonLotto;
    }

    public LottoNumber getBonusNo() {
        return bonusNo;
    }

    public LottoRank checkRanking(Lotto lotto) {
        int matchNo = wonLotto.checkSameCount(lotto);

        if (matchNo < NON_GRADE_NUMBER)
            return LottoRank.NONE;

        if (matchNo == BONUS_NUMBER_MATCHING_COUNT)
            return lotto.getLottoNumbers().contains(bonusNo) ? LottoRank.SECOND : LottoRank.THIRD;

        if (matchNo < BONUS_NUMBER_MATCHING_COUNT)
            return LottoRank.values()[convertRank(matchNo)];

        return LottoRank.FIRST;
    }

    private int convertRank(int matchNo) {
        return 7 - matchNo;
    }

}
