package lotto;

public enum LottoRank {
    NONE(0), FIRST(2000000000), SECOND(30000000),
    THIRD(1500000), FOURTH(50000), FIFTH(5000);

    private int money;
    LottoRank(int money){
        this.money=money;
    }

    public int getMoney(){
        return money;
    }
}
